package org.example.likelion.week6.config;

import org.example.likelion.week6.Repository.MemberRepository;
import org.example.likelion.week6.Repository.MemoryMemberRepository;
import org.example.likelion.week6.Service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
