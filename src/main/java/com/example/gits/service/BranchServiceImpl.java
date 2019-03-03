package com.example.gits.service;

import com.example.gits.ctx.Dao;
import com.example.gits.spm.dbms.gitsdb.gitrepos.Gitrepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    Dao dao;

    @Override
    public void createBranch(String groupName) {
        List<Gitrepos> repoList = dao.REPOSITORY.stream()
                .filter(Gitrepos.GROUP.equalIgnoreCase(groupName))
                .collect(Collectors.toList());

    }
}
