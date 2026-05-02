package org.example.likelion.week2.Step1;

import org.example.likelion.week2.Step1.Service.MemberService;

public class Main {
    public static void main(String[] args) {

        System.out.println("main 시작");
        MemberService service = new MemberService();

        service.join("윤해인");
        service.join("철수");
        service.join("짱구");
        System.out.println("가입 끝");

        Member member = service.findMember("철수");
        System.out.println("조회 끝");

        System.out.println(member.getName());

    }
}
