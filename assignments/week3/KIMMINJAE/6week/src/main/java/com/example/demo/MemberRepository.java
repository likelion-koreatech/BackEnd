package com.example.demo;

import com.example.demo.role.Member;

import java.util.List;

public interface MemberRepository {


    void saveMember (Member member);


    Member searchMember (String name);

    List<Member> findAll();




    boolean is_existName(String name);
}


