package role;


import policy.SubmissionPolicy;

public abstract class Role {
    String name;
    String major;
    int Cohort;
    String part;

    public Role(String name, String major, int cohort, String part) {
        this.name = name;
        this.major = major;
        Cohort = cohort;
        this.part = part;
    }

    abstract SubmissionPolicy getPolicy();

    public abstract void showRole();

    boolean torf(){
        return getPolicy().check();
    }

    public String getName() {
        return name;
    }

    public abstract String show();

    public int getCohort() {
        return Cohort;
    }

    public String getPart() {
        return part;
    }
}
