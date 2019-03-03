package com.example.gits.ctrl;

import com.example.gits.ctx.Dao;
import com.example.gits.spm.dbms.gitsdb.gitbranch.Gitbranch;
import com.example.gits.spm.dbms.gitsdb.gitbranch.GitbranchImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("branch")
public class BranchController {
    public static final String LIST = "branch/list";
    public static final String CREATE = "branch/create";
    public static final String SUCCESS = "branch/success";
    public static final String REDIRECT_SUCCESS = "redirect:/branch/success";

    @Autowired
    Dao dao;

    @GetMapping(value = {"/list/{projectId}"})
    public String list(Model model, @PathVariable("projectId") long projectId) {
        List<String> branchList = dao.BRANCH.stream()
                .filter(Gitbranch.PROJECT_ID.equal(projectId))
                .map(Gitbranch.NAME)
                .distinct()
                .collect(Collectors.toList());
        model.addAttribute("branchList", branchList);
        return LIST;
    }

    @GetMapping(value = {"/create/{group}"})
    public String create(Model model,@PathVariable("group") String group) {
        Gitbranch branch = new GitbranchImpl();
        model.addAttribute("branchModel", branch);
        return CREATE;
    }

    @PostMapping(value = {"/create/{group}"})
    public String createRepo(@ModelAttribute GitbranchImpl branch, @PathVariable("group") String group) {
        branch.setCreationTime(LocalDateTime.now())
                .setUpdateTime(LocalDateTime.now());
        branch.setChash("chash");
        Gitbranch saved = dao.BRANCH.persist(branch);
        return REDIRECT_SUCCESS;
    }

    @GetMapping(value = {"/success"})
    public String success() {

        return SUCCESS;
    }
}
