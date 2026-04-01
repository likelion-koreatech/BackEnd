package Package2;

import java.util.ArrayList;
import role.Member;
import java.util.List;

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