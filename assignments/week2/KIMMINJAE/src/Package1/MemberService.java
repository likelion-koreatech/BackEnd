package Package1;

import role.Lion;
import role.Member;
import role.Staff;

import java.util.List;

public class MemberService {
    private MemberRepository repository = new MemberRepository();

    public boolean registerLion(String name, String major, int rltn, String part, int stuNum) {
        if(repository.is_existName(name)){
            return false;
        }repository.saveMember(new Lion(name, major, rltn, part, stuNum));
        return true;
    }

    public boolean registerStaff(String name, String major, int rltn, String part, String wlrcor) {
        if (repository.is_existName(name)) return false;
        repository.saveMember(new Staff(name, major, rltn, part, wlrcor));
        return true;
    }

    public Member SearchService(String name) {
       return repository.searchMember(name);

    }

    public List<Member> GetFindAll(){
        return repository.findAll();
    }


}
