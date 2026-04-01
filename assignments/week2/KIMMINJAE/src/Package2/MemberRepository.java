package Package2;

import role.Member;

import java.util.List;

public interface MemberRepository {


    void saveMember (Member member);


    Member searchMember (String name);

    List<Member> findAll();




    boolean is_existName(String name);
}


