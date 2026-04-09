package org.example.likelion.week6.step2.Config;

import org.example.likelion.week6.step2.Repository.MemberRepository;
import org.example.likelion.week6.step2.Service.MemberService;
import org.example.likelion.week6.step2.Repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
}
