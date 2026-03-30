package role;

import policy.SubmissionPolicy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Role {
    public String name;
    public String major;
    public int batch;
    public String part;
    public SubmissionPolicy submissionPolicy;

    public Role(String name, String major, int batch, String part) {
        this.name = name;
        this.major = major;
        this.batch = batch;
        this.part = part;
    }

    public SubmissionPolicy getPolicy() {
        return submissionPolicy;
    }

    public String information() {
        return "이름: " + name + " | " +
                "전공: " + major + " | " +
                "기수: " + batch + " | " +
                "파트: " + part + "\n";
    }

    public boolean isSubmit() {
        return submissionPolicy.isSubmit();
    }

    public boolean isLion() {
        return submissionPolicy.isSubmit();
    }
}
