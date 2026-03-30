package package2;

import role.Role;

import java.util.List;

public interface MemberRepository {
    public void save(Role role);
    public boolean existsByName(String name);
    public Role findByName(String name);
    public List<Role> findAll();
}
