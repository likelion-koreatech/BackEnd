package phh.mission9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phh.mission9.domain.Assignment;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByMemberId(Long memberId);
}
