package phh.mission8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phh.mission8.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByName(String name);
}
