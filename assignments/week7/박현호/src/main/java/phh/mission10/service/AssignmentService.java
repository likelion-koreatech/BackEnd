package phh.mission10.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phh.mission10.domain.Assignment;
import phh.mission10.domain.Member;
import phh.mission10.global.exception.AssignmentNotFoundException;
import phh.mission10.global.exception.MemberNotFoundException;
import phh.mission10.repository.AssignmentRepository;
import phh.mission10.repository.MemberRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;
    private final MemberRepository memberRepository;

    public AssignmentService(AssignmentRepository assignmentRepository, MemberRepository memberRepository) {
        this.assignmentRepository = assignmentRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Assignment createAssignment(Long memberId, String title, String description) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberNotFoundException("멤버를 찾을 수 없습ㄴ디ㅏ."));
        Assignment assignment = new Assignment(title, description, member);
        assignmentRepository.save(assignment);
        return assignment;
    }

    public List<Assignment> findByMemberId(Long memberId) {
        return assignmentRepository.findByMemberId(memberId);
    }

    public Assignment findById(Long id) {
        return assignmentRepository.findById(id).orElseThrow(() -> new AssignmentNotFoundException("과제를 찾을 수 없습니다."));
    }

    @Transactional
    public Assignment update(Long id, String title, String description) {
        Assignment assignment = assignmentRepository.findById(id).orElseThrow(() -> new AssignmentNotFoundException("과제를 찾을 수 없습니다."));

        assignment.updateInfo(title, description);

        // 더티 체킹으로 안 해도 됨
        assignmentRepository.save(assignment);

        return assignment;
    }

    @Transactional
    public void delete(Long id) {
        assignmentRepository.findById(id).orElseThrow(() -> new AssignmentNotFoundException("과제를 찾을 수 없습니다."));
        assignmentRepository.deleteById(id);
    }

    public List<Assignment> findByTitleContaining(String title) {
        return assignmentRepository.findByTitleContaining(title).orElseThrow(() -> new AssignmentNotFoundException("과제를 찾을 수 없습니다."));
    }

}
