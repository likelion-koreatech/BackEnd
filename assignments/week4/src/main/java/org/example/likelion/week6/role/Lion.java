package org.example.likelion.week6.role;

import org.example.likelion.week6.policy.LionSubmissionPolicy;
import org.example.likelion.week6.policy.SubmissionPolicy;

public class Lion extends Role {
    private final int studentId;

    public Lion(String name, String major, int generation, String part, int studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    @Override
    public SubmissionPolicy getSubmissionPolicy() {
        return new LionSubmissionPolicy();
    }

    @Override
    public String getRoleName() {
        return "아기사자";
    }

    @Override
    public String getDetailInfo() {
        return "학번: " + studentId;
    }
}
