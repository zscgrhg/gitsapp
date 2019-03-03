package com.example.gits.service;

import org.eclipse.jgit.diff.DiffEntry;

import java.util.List;
import java.util.Map;

public interface BranchService {
    void createRemoteBranch(String g, String startRef, String b);

    Map<String, List<DiffEntry>> groupDiff(String branchName, String group);
}
