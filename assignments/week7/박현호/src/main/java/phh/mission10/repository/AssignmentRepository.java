package phh.mission10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phh.mission10.domain.Assignment;

import java.util.List;
import java.util.Optional;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByMemberId(Long memberId);

    Optional<List<Assignment>> findByTitleContaining(String title);
}
