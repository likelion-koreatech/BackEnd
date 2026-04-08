package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.MemberRepository;
import com.example.demo.role.Lion;
import com.example.demo.role.Member;
import com.example.demo.role.Staff;
import java.util.List;
import org.springframework.stereotype.Service;

@Service

public class MemberService {
    private final com.example.demo.MemberRepository repository;
    @Autowired // 생성자가 1개니까 생략가능
    public MemberService(MemberRepository repository) { //생성지에서 주입받는다 = Service 내부에서 Repository 객체를 직접 생성하지 않는다.라는 조건 만족하기위해서
        this.repository = repository;
    }

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
