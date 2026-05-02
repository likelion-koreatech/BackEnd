package phh.mission7.service;

import phh.mission7.dto.LionCreateRequest;
import phh.mission7.dto.LionUpdateRequest;
import phh.mission7.dto.StaffCreateRequest;
import phh.mission7.dto.StaffUpdateRequest;
import phh.mission7.repository.MemoryMemberRepository;
import phh.mission7.domain.role.Lion;
import phh.mission7.domain.role.Role;
import phh.mission7.domain.role.Staff;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemoryMemberRepository memberRepository;

    public MemberService(MemoryMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Lion createLion(LionCreateRequest dto) {
        if(memberRepository.existsByName(dto.name)) {
            return null;
        }
        Lion lion = dto.newLion();
        memberRepository.save(lion);
        return lion;
    }

    public Staff createStaff(StaffCreateRequest dto) {
        if(memberRepository.existsByName(dto.name)) {
            return null;
        }
        Staff staff = dto.newStaff();
        memberRepository.save(staff);
        return staff;
    }

    public Lion updateLion(String name, LionUpdateRequest dto) {
        Lion lion = (Lion)memberRepository.findByName(name);
        if (lion == null) {
            return null;
        }
        lion.major = dto.major;
        lion.generation = dto.generation;
        lion.part = dto.part;
        lion.stuId = dto.studentId;
        memberRepository.updateByName(name, lion);
        return lion;
    }

    public Staff updateStaff(String name, StaffUpdateRequest dto) {
        Staff staff = (Staff)memberRepository.findByName(name);
        if (staff == null) {
            return null;
        }
        staff.major = dto.major;
        staff.generation = dto.generation;
        staff.part = dto.part;
        staff.position = dto.position;
        memberRepository.updateByName(name, staff);
        return staff;
    }

    public boolean deleteMember(String name) {
        return memberRepository.deleteByName(name);
    }

    public Role findByName(String name) {
        Role role = memberRepository.findByName(name);
        if (role == null) {
            return null;
        }
        return role;
    }
}
