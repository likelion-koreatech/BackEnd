package Package1;

import policy.SubmitPolicy;
import policy.StaffSubmit;
import policy.LionSubmit;
import role.Staff;
import role.Lion;
import role.Member;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private List<Member> members = new ArrayList<>();


    public void saveMember (Member m){
        members.add(m);
}


    public Member searchMember (String name){
        boolean found = false;
        for (Member m : members ){
            if (m.name.equals(name)){
                found = true;
                return m;
            }

        }
        return null;
    }

    public List<Member> findAll(){
        return members;

    }

    public boolean is_existName(String name){
        return searchMember(name) != null; //true = 중복 . false = 중복아님

        }
    }


