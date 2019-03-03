package com.example.gits.ctrl;

import com.example.gits.ctx.Dao;
import com.example.gits.spm.dbms.gitsdb.gitrepos.Gitrepos;
import com.example.gits.spm.dbms.gitsdb.gitrepos.GitreposImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class IndexController {

    @Autowired
    Dao dao;
    @RequestMapping({"", "/"})
    public String index(Model model) {
        List<String> rGroupList = dao.REPOSITORY.stream()
                .map(Gitrepos.GROUP)
                .distinct()
                .collect(Collectors.toList());
        model.addAttribute("rGroupList", rGroupList);
        model.addAttribute("repoModel", new GitreposImpl());
        return "index";
    }
}
