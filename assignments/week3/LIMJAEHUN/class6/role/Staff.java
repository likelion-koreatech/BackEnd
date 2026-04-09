package likelion.class6.role;


import likelion.class6.policy.StaffSubmissionPolicy;
import likelion.class6.policy.SubmissionPolicy;

public class Staff extends Role{
    String position;


    public Staff(String name, String major, int cohort, String part, String position) {
        super(name, major, cohort, part);
        this.position = position;
    }

    @Override
    SubmissionPolicy getPolicy() {
        return new StaffSubmissionPolicy();
    }

    @Override
    public void showRole() {
        System.out.println("====결과 출력====");
        System.out.println("역할 : 운영진");
        System.out.println("이름 : "+this.name + " | 전공 : "+this.major + " | 기수 : "+this.Cohort +
                " | 파트 : "+this.part);
        System.out.println("학번 : "+this.position);
        System.out.println("과제 제출 가능 여부 : "+ torf());
    }

    @Override
    public String show(){
        return "운영진";
    }

}
