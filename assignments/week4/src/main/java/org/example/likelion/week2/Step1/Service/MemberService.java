package org.example.likelion.week2.Step1.Service;

import org.example.likelion.week2.Step1.Member;
import org.example.likelion.week2.Step1.Repository.MemberRepository;

import java.util.List;

public class MemberService {

    private final MemberRepository repository = new MemberRepository();

    // TODO: 회원 가입 기능 구현
    public void join(String name) {
        if (repository.existsByName(name)) {     // 이름 중복 검사 (repository.existsByName)
            System.out.println("중복된 이름입니다."); // 중복이면 예외 처리 or 메시지 출력
            return;
        }

        Member member = new Member(name);
        repository.save(member);

        System.out.println("회원 등록 완료");
    }

    // TODO: 이름으로 회원 조회 기능 구현
    //  - repository.findByName 호출
    public Member findMember(String name) {
        return repository.findByName(name);
    }

    // TODO: 전체 회원 조회 기능 구현
    //  - repository.findAll 호출
    public List<Member> findAllMembers() {
        return repository.findAll();
    }

}
