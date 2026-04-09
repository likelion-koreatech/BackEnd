package likelion.class6;

import likelion.class6.config.AppConfig;
import likelion.class6.role.Lion;
import likelion.class6.role.Role;
import likelion.class6.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PblApplication {
    public static void main(String[] args){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        //테스트 role 생성
        Role role = new Lion("forTEST", "CSE", 14, "Back-End", 2022136123);
        if(memberService.register(role)){
            System.out.println("등록 완료");
        } else{
            System.out.println("등록 실패");
        }

        memberService.getMemberByName("forTEST");





    }
}
