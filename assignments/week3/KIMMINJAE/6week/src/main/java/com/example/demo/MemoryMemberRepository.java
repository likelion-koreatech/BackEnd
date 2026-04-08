package com.example.demo;

import com.example.demo.role.Member;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryMemberRepository implements MemberRepository{
    private final List<Member> members = new ArrayList<>();

    @Override
    public void saveMember(Member member) { members.add(member); }
    @Override
    public Member searchMember(String name) {
        for (Member m : members) {
            if (m.name.equals(name)) return m;
        }
        return null;
    }
    @Override
    public List<Member> findAll() { return members; }

    @Override
    public boolean is_existName(String name) { return searchMember(name) != null; }
}
