package org.example.likelion.week2.Step1.Repository;

import org.example.likelion.week2.Step1.Member;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    // TODO: 멤버 데이터를 저장할 자료구조 선언 (ex: List<Member>)
    private final List<Member> members = new ArrayList<>();

    // TODO: 멤버 저장 기능 구현 (save)
    public void save(Member member) {
        members.add(member);
    }
    // TODO: 이름으로 멤버 조회 기능 구현 (findByName)
    public Member findByName(String name) {
        for (Member member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    // TODO: 전체 멤버 조회 기능 구현 (findAll)
    public List<Member> findAll() {
        return members;
    }
    // TODO: 이름 중복 확인 기능 구현 (existsByName)
    public boolean existsByName(String name) {
        for (Member member : members) {
            if (member.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

}
