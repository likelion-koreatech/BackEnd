package class7.repository;

import class7.domain.role.Role;

import java.util.List;

public interface MemberRepository {
    void save(Role role);
    Role findByName(String name);
    List<Role> findAll();
    boolean existsByName(String name);
    void updateByName(String name, Role member);
    boolean deleteByName(String name);
}
