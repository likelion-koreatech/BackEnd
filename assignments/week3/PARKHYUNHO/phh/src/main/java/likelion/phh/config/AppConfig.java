package likelion.phh.config;

import likelion.phh.repository.MemoryMemberRepository;
import likelion.phh.service.MemberService;
import org.springframework.context.annotation.Bean;

//@Configuration
public class AppConfig {

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService(MemoryMemberRepository memberRepository) {
        return new MemberService(memberRepository);
    }
}
