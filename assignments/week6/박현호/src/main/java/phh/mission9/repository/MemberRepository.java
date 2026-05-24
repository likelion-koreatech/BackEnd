package phh.mission9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phh.mission9.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByName(String name);
}