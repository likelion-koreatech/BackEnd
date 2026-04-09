package org.example.likelion.week6.policy;

public class StaffSubmissionPolicy implements SubmissionPolicy {

    @Override
    public boolean canSubmit() {
        return false; // 운영진은 불가능
    }
}
