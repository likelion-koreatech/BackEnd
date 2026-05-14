package week08.service;

import week08.domain.Member;
import week08.domain.RoleType;
import week08.dto.*;
import week08.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    @Autowired // @Autowired 생략 가능
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createLion(String name, String major, String part, int generation, String studentId) {
        Member member = new Member(name, major, part, generation, RoleType.LION, studentId, null);
        return memberRepository.save(member);
    }

    // Staff 생성
    public Member createStaff(String name, String major, String part, int generation, String position) {
        Member member = new Member(name, major, part, generation, RoleType.STAFF, null, position);
        return memberRepository.save(member);
    }

    // 전체 조회
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    // 단건 조회 (id)
    public Member findById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public Member updateLion(Long id, String major, String part, int generation, String studentId) {
        Member member = memberRepository.findById(id).orElse(null);
        member.updateInfo(major, part, generation);
        member.updateStudentId(studentId);
        return memberRepository.save(member);
    }

    // Staff 수정
    public Member updateStaff(Long id, String major, String part, int generation, String position) {
        Member member = memberRepository.findById(id).orElse(null);
        member.updateInfo(major, part, generation);
        member.updatePosition(position);
        return memberRepository.save(member);
    }

    // 삭제
    public void delete(Long id) {
        memberRepository.deleteById(id);
    }
}
