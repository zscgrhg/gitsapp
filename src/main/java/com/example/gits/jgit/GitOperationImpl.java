package com.example.gits.jgit;

import com.example.gits.spm.dbms.gitsdb.gitrepos.Gitrepos;
import lombok.SneakyThrows;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.FetchResult;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.treewalk.AbstractTreeIterator;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class GitOperationImpl implements GitOperation {
    public static final File workspace = new File("./workspace");

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
                FetchResult result = git.fetch().setCheckFetchedObjects(true)
                        .setTransportConfigCallback(SshTransportConfigCallback.INSTANCE).call();
                return git;
            }
        }
        workDir.mkdirs();
        Git git = Git
                .cloneRepository()
                .setDirectory(workDir)
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
        PushCommand pushCommand = git.push();
        pushCommand.setTransportConfigCallback(SshTransportConfigCallback.INSTANCE);
        pushCommand.setRemote("origin");
        pushCommand.setRefSpecs(new RefSpec().setSourceDestination(source, dest));
        pushCommand.call();
    }

    @SneakyThrows
    public List<DiffEntry> diff(Git git, String oldBranch, String newBranch) {
        Repository repository = git.getRepository();
        checkLocalBranch(git, oldBranch);
        checkLocalBranch(git, newBranch);
        AbstractTreeIterator oldTreeParser = prepareTreeParser(repository, "refs/heads/" + oldBranch);
        AbstractTreeIterator newTreeParser = prepareTreeParser(repository, "refs/heads/" + newBranch);

        // then the procelain diff-command returns a list of diff entries
        List<DiffEntry> diff = git.diff().setOldTree(oldTreeParser).setNewTree(newTreeParser).call();
        return diff;
    }


    private void checkLocalBranch(Git git, String branch) throws IOException, GitAPIException {
        Repository repository = git.getRepository();
        if (repository.exactRef("refs/heads/" + branch) == null) {
            // first we need to ensure that the remote branch is visible locally
            git.branchCreate().setName(branch).setStartPoint("origin/" + branch).call();
        }
    }

    private AbstractTreeIterator prepareTreeParser(org.eclipse.jgit.lib.Repository repository, String ref) throws IOException {
        // from the commit we can build the tree which allows us to construct the TreeParser
        Ref head = repository.exactRef(ref);
        try (RevWalk walk = new RevWalk(repository)) {
            RevCommit commit = walk.parseCommit(head.getObjectId());
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
