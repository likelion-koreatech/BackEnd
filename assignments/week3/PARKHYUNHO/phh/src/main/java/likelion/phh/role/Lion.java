package likelion.phh.role;

import likelion.phh.policy.LionSubmissionPolicy;
import likelion.phh.policy.SubmissionPolicy;

public class Lion extends Role {
    private String stuId;

    public Lion(String name, String major, int batch, String part, String stuId) {
        super(name, major, batch, part);
        this.stuId = stuId;
        submissionPolicy = new LionSubmissionPolicy();
    }

    @Override
    public SubmissionPolicy getPolicy() {
        return submissionPolicy;
    }

    @Override
    public String information() {
        return "역할: 아기사자\n" + super.information() +
                "학번: " + stuId +
                "\n과제 제출 가능 여부: " + (isSubmit() ? "가능" : "불가능") +
                "\n----------------";
    }
}