package com.example.gits.jgit;

import com.example.gits.ctx.Dao;
import com.example.gits.spm.dbms.gitsdb.gitrepos.Gitrepos;
import lombok.SneakyThrows;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.eclipse.jgit.api.CreateBranchCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ListBranchCommand;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.lib.*;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.FetchResult;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.treewalk.AbstractTreeIterator;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class GitOperationImpl implements GitOperation {
    public static final File workspace = new File("./workspace");
    @Autowired
    Dao dao;
    static {
        if (!workspace.exists()) {
            workspace.mkdirs();
        }
    }

    @Override
    @SneakyThrows
    public Git gitClone(Gitrepos repository) {

        File workDir = workspace.toPath().resolve(repository.getName()).toFile();
        if (workDir.exists()) {
            File repoDir = workDir.toPath().resolve(".git").toFile();
            if (!repoDir.exists()) {
                FileUtils.deleteDirectory(workDir);
            } else {
                FileRepositoryBuilder builder = new FileRepositoryBuilder();
                Repository r = builder
                        .setGitDir(repoDir)
                        .readEnvironment() // scan environment GIT_* variables
                        .findGitDir() // scan up the file system tree
                        .build();
                Git git = new Git(r);
                FetchResult result = git.fetch()
                        .setForceUpdate(true)
                        .setCheckFetchedObjects(true)
                        .setTransportConfigCallback(SshTransportConfigCallback.INSTANCE).call();
                return git;
            }
        }
        workDir.mkdirs();
        Git git = Git
                .cloneRepository()
                .setDirectory(workDir)
                .setCloneAllBranches(true)
                .setNoCheckout(true)
                .setTransportConfigCallback(SshTransportConfigCallback.INSTANCE)
                .setURI(repository.getRepository())
                .call();
        return git;
    }


    @Override
    @SneakyThrows
    public void gitCheckout(Git git, String start, String branchName) {

        git.checkout()
                .setCreateBranch(true)
                .setName(branchName)
                .setStartPoint(start)
                .call();
    }

    @Override
    @SneakyThrows
    public void gitBranchPush(Git git, String source, String dest) {

//        List<Ref> call = git.branchList().setListMode(ListBranchCommand.ListMode.REMOTE).call();
//        String name = dest.replaceFirst("^.*/","");
//        Optional<Ref> first = call.stream().filter(c ->
//                name.equals(c.getName().replaceFirst("^.*/",""))
//        ).findFirst();
//        if(!first.isPresent()){
//
//        }else {
//
//        }
        PushCommand pushCommand = git.push();
        pushCommand.setTransportConfigCallback(SshTransportConfigCallback.INSTANCE);
        pushCommand.setRemote("origin");
        pushCommand.setForce(true);
        pushCommand.setRefSpecs(new RefSpec().setSourceDestination(source, dest));
        Iterable<PushResult> pushResults = pushCommand.call();
    }

    @Override
    @SneakyThrows
    public void createBranch(Git git, String start, String branchName) {
        Ref call = git.branchCreate()
                .setStartPoint(start)
                .setName(branchName)
                .setForce(true)
                .call();
        System.out.println(ObjectId.toString(call.getObjectId()));
    }

    @Override
    @SneakyThrows
    public String revParse(Git git, String ref) {
        Ref refObj = git.getRepository().exactRef(ref);
        return ObjectId.toString(refObj.getObjectId());
    }

    @SneakyThrows
    public List<DiffEntry> diff(Git git, String oldBranch, String newBranch) {
        Repository repository = git.getRepository();
        git.branchCreate()
                .setForce(true)
                .setUpstreamMode(CreateBranchCommand.SetupUpstreamMode.TRACK)
                .setName(oldBranch).setStartPoint("origin/" + oldBranch).call();
        git.branchCreate()
                .setForce(true)
                .setUpstreamMode(CreateBranchCommand.SetupUpstreamMode.TRACK)
                .setName(newBranch).setStartPoint("origin/" + newBranch).call();
        ObjectId oldObjectId = repository.exactRef("refs/heads/" + oldBranch).getObjectId();
        ObjectId newObjectId = repository.exactRef("refs/heads/" + newBranch).getObjectId();
        AbstractTreeIterator oldTreeParser = prepareTreeParser(repository, oldObjectId);
        AbstractTreeIterator newTreeParser = prepareTreeParser(repository, newObjectId);

        // then the procelain diff-command returns a list of diff entries
        List<DiffEntry> diff = git.diff().setOldTree(oldTreeParser).setNewTree(newTreeParser).call();
        return diff;
    }

    @SneakyThrows
    public List<DiffEntry> diffChash(Git git, String oldHash, String newHash) {
        Repository repository = git.getRepository();

        ObjectId oldObjectId = ObjectId.fromString(oldHash);
        ObjectId newObjectId = ObjectId.fromString(newHash);
        AbstractTreeIterator oldTreeParser = prepareTreeParser(repository, oldObjectId);
        AbstractTreeIterator newTreeParser = prepareTreeParser(repository, newObjectId);

        // then the procelain diff-command returns a list of diff entries
        List<DiffEntry> diff = git.diff().setOldTree(oldTreeParser).setNewTree(newTreeParser).call();
        return diff;
    }



    private AbstractTreeIterator prepareTreeParser(Repository repository, AnyObjectId objectId) throws IOException {
        // from the commit we can build the tree which allows us to construct the TreeParser

        try (RevWalk walk = new RevWalk(repository)) {
            RevCommit commit = walk.parseCommit(objectId);
            RevTree tree = walk.parseTree(commit.getTree().getId());

            CanonicalTreeParser treeParser = new CanonicalTreeParser();
            try (ObjectReader reader = repository.newObjectReader()) {
                treeParser.reset(reader, tree.getId());
            }
            walk.dispose();
            return treeParser;
        }
    }
}
