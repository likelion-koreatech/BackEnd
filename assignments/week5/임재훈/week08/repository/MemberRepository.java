package week08.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import week08.domain.Member;
import week08.domain.role.Role;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
