package phh.mission7.repository;

import phh.mission7.domain.role.Role;

public interface MemberRepository {
    void updateByName(String name, Role member);
    boolean deleteByName(String name);
    boolean existsByName(String name);
}
