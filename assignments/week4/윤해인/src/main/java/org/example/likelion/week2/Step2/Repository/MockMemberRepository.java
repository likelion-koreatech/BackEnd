package org.example.likelion.week2.Step2.Repository;

import org.example.likelion.week2.Step2.Member;

import java.util.ArrayList;
import java.util.List;

public class MockMemberRepository implements MemberRepository {

    @Override
    public void save(Member member) {
        System.out.println("[Mock] 저장하지 않습니다: " + member.getName());
    }

    @Override
    public Member findByName(String name) {
        if (name.equals("철수")) {
            return new Member("철수");
        }
        return null;
    }

    @Override
    public List<Member> findAll() {
        List<Member> mockMembers = new ArrayList<>();
        mockMembers.add(new Member("가짜회원1"));
        mockMembers.add(new Member("가짜회원2"));
        return mockMembers;
    }

    @Override
    public boolean existsByName(String name) {
        return name.equals("철수");
    }
}