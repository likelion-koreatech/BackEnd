package phh.mission10.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phh.mission10.domain.Member;
import phh.mission10.domain.RoleType;
import phh.mission10.dto.LionCreateRequest;
import phh.mission10.dto.LionUpdateRequest;
import phh.mission10.dto.StaffCreateRequest;
import phh.mission10.dto.StaffUpdateRequest;
import phh.mission10.global.exception.DuplicateMemberException;
import phh.mission10.global.exception.MemberNotFoundException;
import phh.mission10.repository.MemberRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Member createLion(LionCreateRequest dto) {
        if (memberRepository.existsByName(dto.name)) {
            throw new DuplicateMemberException("이미 존재하는 이름입니다.");
        }
        Member member = new Member(dto.name, dto.major, dto.generation, dto.part, RoleType.LION, dto.studentId, null);
        memberRepository.save(member);
        return member;
    }

    @Transactional
    public Member createStaff(StaffCreateRequest dto) {
        if (memberRepository.existsByName(dto.name)) {
            throw new DuplicateMemberException("이미 존재하는 이름입니다.");
        }
        Member member = new Member(dto.name, dto.major, dto.generation, dto.part, RoleType.STAFF, null, dto.position);
        memberRepository.save(member);
        return member;
    }

    @Transactional
    public Member updateLion(Long id, LionUpdateRequest dto) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException("멤버를 찾을 수 없습니다."));
        member.updateInfo(dto.major, dto.generation, dto.part, dto.studentId, null);
        return member;
    }

    @Transactional
    public Member updateStaff(Long id, StaffUpdateRequest dto) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException("멤버를 찾을 수 없습니다."));
        member.updateInfo(dto.major, dto.generation, dto.part, null, dto.position);
        return member;
    }

    @Transactional
    public void deleteMember(Long id) {
        findById(id);
        memberRepository.deleteById(id);
    }

    public Member findById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException("멤버를 찾을 수 없습니다."));
    }

    public List<Member> findMembersByPart(String part) {
        return memberRepository.findMemberAllByPart(part).orElseThrow(() -> new MemberNotFoundException("멤버를 찾을 수 없습니다."));
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }
}
