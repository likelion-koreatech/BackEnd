package phh.mission9.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phh.mission9.domain.Assignment;
import phh.mission9.domain.Member;
import phh.mission9.repository.AssignmentRepository;
import phh.mission9.repository.MemberRepository;

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
        Member member = memberRepository.findById(memberId).orElse(null);
        if (member == null) {
            return null;
        }
        Assignment assignment = new Assignment(title, description, member);
        assignmentRepository.save(assignment);
        return assignment;
    }

    public List<Assignment> findByMemberId(Long memberId) {
        return assignmentRepository.findByMemberId(memberId);
    }

    public Assignment findById(Long id) {
        return assignmentRepository.findById(id).orElse(null);
    }

    @Transactional
    public Assignment update(Long id, String title, String description) {
        Assignment assignment = assignmentRepository.findById(id).orElse(null);
        if (assignment != null) {
            assignment.updateInfo(title, description);
            
            // 더티 체킹으로 안 해도 됨
            assignmentRepository.save(assignment);
        }
        return assignment;
    }

    @Transactional
    public boolean delete(Long id) {
        Assignment assignment = assignmentRepository.findById(id).orElse(null);
        if (assignment == null) {
            return false;
        }
        assignmentRepository.deleteById(id);
        return true;
    }

}
