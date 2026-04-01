package role;

public abstract class Member {
    public String name;
    private String major;
    private int rltn;
    private String part;

    //private int Stu_Num;

    public Member (String name,String major,int rltn,String part){
        this.name = name;
        this.major = major;
        this.rltn = rltn;
        this.part = part;


    }
    public String getMajor() {
        return major;
    }

    public int getRltn() {
        return rltn;
    }

    public String getPart() {
        return part;
    }

    public abstract String getRole();
    public abstract String getExtraInfo();

    public void printInfo() {
        System.out.println("🎭 역할: " + getRole());
        System.out.println("👤 이름: " + name + " | 🎓 전공: " + major + " | 📌 기수: " + rltn + " | 💻 파트: " + part);
        System.out.println(getExtraInfo());
        System.out.println("------------------------");
    }
    public boolean isEmpty(){
        return true;
    }
}


