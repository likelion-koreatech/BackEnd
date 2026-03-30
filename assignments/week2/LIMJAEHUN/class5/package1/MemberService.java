package package1;

import role.Role;

import java.util.List;

public class MemberService {

    private MemberRepository memberRepository = new MemberRepository();

    // 멤버 등록
    public boolean register(Role role){
        if(!memberRepository.checkDupl(role.getName())){
            memberRepository.save(role);
            return true;
        } else{
            return false;
        }
    }

    // 이름으로 조회
    public Role getMemberByName(String name){
        if (memberRepository.checkDupl(name)){
            return memberRepository.findByName(name);
        } else{
            return null;
        }

    }

    // 전체 멤버 조회
    public List<Role> getAllMember(){
        return memberRepository.findAll();
    }
}
