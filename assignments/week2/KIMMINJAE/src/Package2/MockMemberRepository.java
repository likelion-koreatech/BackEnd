package Package2;
import java.util.ArrayList;
import role.Member;
import java.util.List;
import role.Staff;
import role.Lion;
public class MockMemberRepository implements MemberRepository{
    @Override
    public void saveMember(Member member) {
        // 저장 안 함 (mock)
    }

    @Override
    public Member searchMember(String name) {
        if (name.equals("mockLion")) return new Lion("mockLion","CS",13,"백엔드",20240001);
        if (name.equals("mockStaff")) return new Staff("mockStaff","Design",12,"디자인","멘토");
        return null;
    }

    @Override
    public List<Member> findAll() {
        List<Member> dummy = new ArrayList<>();
        dummy.add(new Lion("mockLion","CS",13,"백엔드",20240001));
        dummy.add(new Staff("mockStaff","Design",12,"디자인","멘토"));
        return dummy;
    }

    @Override
    public boolean is_existName(String name) {
        return searchMember(name) != null;
    }
}

