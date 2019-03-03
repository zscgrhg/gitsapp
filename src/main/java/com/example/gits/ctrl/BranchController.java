package com.example.gits.ctrl;

import com.example.gits.ctx.Dao;
import com.example.gits.misc.GitsForkJoinWorkerThreadFactory;
import com.example.gits.service.BranchService;
import com.example.gits.spm.dbms.gitsdb.gitbranch.Gitbranch;
import lombok.SneakyThrows;
import org.eclipse.jgit.diff.DiffEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

@Controller
@RequestMapping("branch")
public class BranchController {
    ForkJoinPool FJP = new ForkJoinPool(16, new GitsForkJoinWorkerThreadFactory(), null, false);
    @Autowired
    Dao dao;
    @Autowired
    BranchService branchService;

    @GetMapping(value = {"/list/{projectId}"})
    public String list(Model model, @PathVariable("projectId") long projectId) {
        List<Gitbranch> branchList = dao.BRANCH.stream()
                .filter(Gitbranch.PROJECT_ID.equal(projectId))
                .collect(Collectors.toList());
        model.addAttribute("branchList", branchList);
        return "branch/list";
    }


    @PostMapping(value = {"/create"})
    @SneakyThrows
    public String createBranch(@RequestParam("b") String branch,
                               @RequestParam("s") String startRef,
                               @RequestParam("g") String group, RedirectAttributes redirectAttributes) {
        final CountDownLatch cdl = new CountDownLatch(1);
        String start = "refs/remotes/origin/"
                + Optional.ofNullable(startRef).filter(s -> !s.isEmpty()).orElse("master");
        Throwable[] throwables = new Throwable[1];
        FJP.execute(() -> {
            try {

                branchService.createRemoteBranch(group, start, branch);
            } catch (Throwable t) {
                throwables[0] = t;
            } finally {
                cdl.countDown();
            }
        });
        cdl.await();
        if (throwables[0] != null) {
            redirectAttributes.addFlashAttribute("branchCreated", branch + " created failed,caused by:" + throwables[0].getMessage());
        } else {
            redirectAttributes.addFlashAttribute("branchCreated", branch + " created successfully.");
        }

        return "redirect:/repo/list/" + group;
    }

    @GetMapping(value = {"/diff"})
    @SneakyThrows
    public String checkUpdates(Model model,
                               @RequestParam("b") String branchName,
                               @RequestParam("g") String group) {
        final CountDownLatch cdl = new CountDownLatch(1);
        Throwable[] throwables = new Throwable[1];
        FJP.execute(() -> {
            try {

                Map<String, List<DiffEntry>> groupDiff = branchService.groupDiff(branchName, group);
                model.addAttribute("groupDiff", groupDiff);
                model.addAttribute("branchName", branchName);
            } catch (Throwable t) {
                throwables[0] = t;
            } finally {
                cdl.countDown();
            }
        });
        cdl.await();
        if (throwables[0] != null) {
            throw throwables[0];
        }

        return "branch/diff";
    }

}
