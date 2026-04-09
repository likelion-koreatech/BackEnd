package org.example.likelion.week2.Step2;

import org.example.likelion.week2.Step2.Repository.MemberRepository;
import org.example.likelion.week2.Step2.Repository.MemoryMemberRepository;
import org.example.likelion.week2.Step2.Service.MemberService;

public class Main {
    public static void main(String[] args) {
        MemberRepository repository = new MemoryMemberRepository();
//        MemberRepository repository = new MockMemberRepository();

        MemberService memberService = new MemberService(repository);

        memberService.join("윤해인");
        memberService.join("철수");
        memberService.join("짱구");

        Member member = memberService.findMember("철수");
        if (member != null) {
            System.out.println(member.getName());
        }
        else {
            System.out.println("회원을 찾지 못했습니다.");
        }
    }
}
