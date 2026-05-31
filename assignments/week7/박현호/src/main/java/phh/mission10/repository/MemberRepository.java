package phh.mission10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phh.mission10.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByName(String name);

    Optional<List<Member>> findMemberAllByPart(String part);
}