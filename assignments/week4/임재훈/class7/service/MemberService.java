package class7.service;

import class7.domain.role.Lion;
import class7.domain.role.Role;
import class7.domain.role.Staff;
import class7.dto.*;
import class7.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    @Autowired // @Autowired 생략 가능
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 생성
    public LionResponse createLion(LionCreateRequest request){
        if (memberRepository.existsByName(request.getName())){
            return null;
        } // 이름이 중복일 경우 null 반환
        Lion lion = new Lion(request);
        memberRepository.save(lion);
        return LionResponse.from(lion);
    }

    public StaffResponse createStaff(StaffCreateRequest request) {
        if (memberRepository.existsByName(request.getName())) {
            return null;
        }
        Staff staff = new Staff(request);
        memberRepository.save(staff);
        return StaffResponse.from(staff);
    }

    // 조회
    public Role findByName(String name){
        return memberRepository.findByName(name);
    }

    // 수정
    public LionResponse updateLion(String name, LionUpdateRequest request){
        Role existing = memberRepository.findByName(name);
        if (existing == null){
            return null;
        } // 업데이트할 이름이 없는 경우
        Lion lion = new Lion(name, request);
        memberRepository.updateByName(name, lion);
        return LionResponse.from(lion);
    }

    public StaffResponse updateStaff(String name, StaffUpdateRequest request){
        Role existing = memberRepository.findByName(name);
        if (existing == null){
            return null;
        } // 업데이트할 이름이 없는 경우
        Staff staff = new Staff(name, request);
        memberRepository.updateByName(name, staff);
        return StaffResponse.from(staff);
    }

    // 삭제
    public boolean deleteMember(String name){
        return memberRepository.deleteByName(name);
    }

}
