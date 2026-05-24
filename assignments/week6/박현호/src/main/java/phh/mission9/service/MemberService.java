package phh.mission9.service;

import org.springframework.transaction.annotation.Transactional;
import phh.mission9.domain.Member;
import phh.mission9.domain.RoleType;
import phh.mission9.dto.LionCreateRequest;
import phh.mission9.dto.LionUpdateRequest;
import phh.mission9.dto.StaffCreateRequest;
import phh.mission9.dto.StaffUpdateRequest;
import org.springframework.stereotype.Service;
import phh.mission9.repository.MemberRepository;

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Member createLion(LionCreateRequest dto) {
        if(memberRepository.existsByName(dto.name)) {
            return null;
        }
        Member member = new Member(dto.name, dto.major, dto.generation, dto.part, RoleType.LION, dto.studentId, null);
        memberRepository.save(member);
        return member;
    }

    @Transactional
    public Member createStaff(StaffCreateRequest dto) {
        if(memberRepository.existsByName(dto.name)) {
            return null;
        }
        Member member = new Member(dto.name, dto.major, dto.generation, dto.part, RoleType.STAFF, null, dto.position);
        memberRepository.save(member);
        return member;
    }

    @Transactional
    public Member updateLion(Long id, LionUpdateRequest dto) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) {
            return null;
        }
        member.updateInfo(dto.major, dto.generation, dto.part, dto.studentId, null);
        return member;
    }

    @Transactional
    public Member updateStaff(Long id, StaffUpdateRequest dto) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) {
            return null;
        }
        member.updateInfo(dto.major, dto.generation, dto.part, null, dto.position);
        return member;
    }

    @Transactional
    public boolean deleteMember(Long id) {
        memberRepository.deleteById(id);
        Member member = findById(id);
        return member == null;
    }

    public Member findById(Long id) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) {
            return null;
        }
        return member;
    }
}
