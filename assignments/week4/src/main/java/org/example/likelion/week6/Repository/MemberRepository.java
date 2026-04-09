package org.example.likelion.week6.Repository;

import org.example.likelion.week2.Step2.Member;

import java.util.List;


public interface MemberRepository {
    void save(Member member);
    Member findByName(String name);
    List<Member> findAll();
    boolean existsByName(String name);
}
