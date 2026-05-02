package org.example.likelion.week6.role;

import org.example.likelion.week6.policy.SubmissionPolicy;

public abstract class Role {
    private String name;
    private String major;
    private int generation;
    private String part;

    public Role (String name, String major, int generation, String part) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }
    // 부모 필드가 private이므로 getter 제공
    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }

    public abstract SubmissionPolicy getSubmissionPolicy();
    public abstract String getRoleName();
    public abstract String getDetailInfo();
    public boolean canSubmit() {
        return getSubmissionPolicy().canSubmit();
    }

    public String getSimpleInfo() {
        return "[" + getRoleName() + "] " + getName() + " - " + getGeneration() + "기";
    }

    public String getFullInfo() {
        return "역할: " + getRoleName()
                + "\n이름: " + getName()
                + "\n전공: " + getMajor()
                + "\n기수: " + getGeneration()
                + "\n파트: " + getPart()
                + "\n" + getDetailInfo()
                + "\n과제 제출 가능 여부: " + (canSubmit() ? "가능" : "불가능");
    }
}
