package org.example.likelion.week6.step2.policy;

public class LionSubmissionPolicy implements SubmissionPolicy {

    @Override
    public boolean canSubmit() {
        return true; // 아기사자는 무조건 가능
    }
}
