package role;

import policy.StaffSubmissionSubmissionPolicy;
import policy.SubmissionPolicy;

public class Staff extends Role {
    private String role;

    public Staff(String name, String major, int batch, String part, String role) {
        super(name, major, batch, part);
        this.role = role;
        submissionPolicy = new StaffSubmissionSubmissionPolicy();
    }

    @Override
    public SubmissionPolicy getPolicy() {
        return submissionPolicy;
    }

    @Override
    public String information() {
        return "역할: 운영진\n" + super.information() +
                "직책: " + role +
                "\n과제 제출 가능 여부: " + (isSubmit() ? "가능" : "불가능") +
                "\n----------------";
    }
}
