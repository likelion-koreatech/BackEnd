package likelion.class6.service;



import likelion.class6.repository.MemberRepository;
import likelion.class6.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository repo) {
        this.memberRepository = repo;
    }

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
