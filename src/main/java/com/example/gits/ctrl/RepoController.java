package com.example.gits.ctrl;


import com.example.gits.ctx.Dao;
import com.example.gits.spm.dbms.gitsdb.gitrepos.Gitrepos;
import com.example.gits.spm.dbms.gitsdb.gitrepos.GitreposImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("repo")
public class RepoController {
    public static final String LIST = "repo/list";
    public static final String CREATE = "repo/create";
    public static final String SUCCESS = "repo/success";
    public static final String REDIRECT_SUCCESS = "redirect:/repo/success";
    @Autowired
    Dao dao;

    @GetMapping(value = {"/list/{group}"})
    public String list(Model model,@PathVariable("group") String group) {
        List<Gitrepos> repoList = dao.REPOSITORY.stream()
                .filter(Gitrepos.GROUP.equalIgnoreCase(group))
                .collect(Collectors.toList());

        model.addAttribute("repoList", repoList);
        return LIST;
    }

    @GetMapping(value = {"/create"})
    public String create(Model model) {
        model.addAttribute("repoModel", new GitreposImpl());
        return CREATE;
    }

    @PostMapping(value = {"/create"})
    public String createRepo(@ModelAttribute GitreposImpl repo, RedirectAttributes redirectAttributes) {
        repo.setCreationTime(LocalDateTime.now())
                .setUpdateTime(LocalDateTime.now());
        Gitrepos saved = dao.REPOSITORY.persist(repo);
        return REDIRECT_SUCCESS;
    }
    @GetMapping(value = {"/success"})
    public String success() {

        return SUCCESS;
    }
}
