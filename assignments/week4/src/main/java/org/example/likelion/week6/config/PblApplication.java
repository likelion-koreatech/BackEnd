package org.example.likelion.week6.config;

import org.example.likelion.week6.Service.MemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PblApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PblApplication.class, args);

        MemberService memberService = context.getBean(MemberService.class);
        memberService.join("해인");
    }
}
