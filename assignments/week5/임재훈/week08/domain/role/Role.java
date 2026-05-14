package week08.domain.role;

public abstract class Role {
    private String name;
    private String major;
    private int generation;
    private String part;
    // 이름, 전공, 기수, 파트

    public Role(String name, String major, int generation, String part) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    public abstract String getRoleName(); // RoleName을 얻는 추상 메서드 > Lion, Staff에서 정의되야 함

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }
}
