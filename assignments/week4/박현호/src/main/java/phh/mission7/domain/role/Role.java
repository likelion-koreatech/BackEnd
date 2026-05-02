package phh.mission7.domain.role;

public abstract class Role {
    public String name;
    public String major;
    public int generation;
    public String part;

    public Role(String name, String major, int generation, String part) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }


    public String information() {
        return "이름: " + name + " | " +
                "전공: " + major + " | " +
                "기수: " + generation + " | " +
                "파트: " + part + "\n";
    }
}
