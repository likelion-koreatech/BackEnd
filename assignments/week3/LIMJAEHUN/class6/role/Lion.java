package likelion.class6.role;


import likelion.class6.policy.LionSubmissionPolicy;
import likelion.class6.policy.SubmissionPolicy;

public class Lion extends Role{
    int id;

    public Lion(String name, String major, int cohort, String part, int id) {
        super(name, major, cohort, part);
        this.id = id;
    }

    @Override
    SubmissionPolicy getPolicy() {
        return new LionSubmissionPolicy();
    }

    @Override
    public void showRole() {
        System.out.println("====결과 출력====");
        System.out.println("역할 : 아기사자");
        System.out.println("이름 : "+this.name + " | 전공 : "+this.major + " | 기수 : "+this.Cohort +
                " | 파트 : "+this.part);
        System.out.println("학번 : "+this.id);
        System.out.println("과제 제출 가능 여부 : "+ torf());
    }

    @Override
    public String show(){
        return "아기사자";
    }


}
