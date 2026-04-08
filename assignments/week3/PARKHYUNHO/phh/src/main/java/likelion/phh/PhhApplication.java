package likelion.phh;

import likelion.phh.service.MemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PhhApplication {

	public static void main(String[] args) {

//        step2 동작 확인
        ApplicationContext context = SpringApplication.run(PhhApplication.class, args);
        MemberService memberService = context.getBean(MemberService.class);
        System.out.println("memberService = " + memberService);

//		SpringApplication.run(PhhApplication.class, args);
	}

}
