package org.example.likelion.week2.Step2.Service;

import org.example.likelion.week2.Step2.Member;
import org.example.likelion.week2.Step2.Repository.MemberRepository;

import java.util.List;

public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) { // new로 직접 생성x 생성자로 주입 받음!
        this.repository = repository;
    }

    // -----------------------------------------------------------------
    public void join(String name) {
        if (repository.existsByName(name)) {
            System.out.println("중복된 이름입니다.");
            return;
        }

        Member member = new Member(name);
        repository.save(member);
    }

    public Member findMember(String name) {
        return repository.findByName(name);
    }

    public List<Member> findAllMembers() {
        return repository.findAll();
    }

}
