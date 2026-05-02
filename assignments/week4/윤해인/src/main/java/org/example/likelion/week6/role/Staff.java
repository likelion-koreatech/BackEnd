package org.example.likelion.week6.role;


import org.example.likelion.week6.policy.StaffSubmissionPolicy;
import org.example.likelion.week6.policy.SubmissionPolicy;

public class Staff extends Role {
    String position; // 직책

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    @Override
    public SubmissionPolicy getSubmissionPolicy() {
        return new StaffSubmissionPolicy();
    }

    @Override
    public String getRoleName() {
        return "운영진";
    }

    @Override
    public String getDetailInfo() {
        return "직책: " + position;
    }
}
