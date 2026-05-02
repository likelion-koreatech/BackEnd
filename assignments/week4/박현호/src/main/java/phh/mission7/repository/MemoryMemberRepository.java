package phh.mission7.repository;

import phh.mission7.domain.role.Role;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private List<Role> roles = new ArrayList<>();

    public void save(Role role) {
        roles.add(role);
    }

    public Role findByName(String name) {
        for (Role role : roles) {
            if(role.name.equals(name)) {
                return role;
            }
        }
        // 못찾으면 예외 처리 -> 근데 서비스에서 그냥 로그 출력함
        return null;
    }

    @Override
    public void updateByName(String name, Role member) {
        for (Role role : roles) {
            if (role.name.equals(name)) {
                roles.indexOf(role);
                roles.set(roles.indexOf(role), member);
            }
        }
    }

    @Override
    public boolean deleteByName(String name) {
        return roles.removeIf((role) -> role.name.equals(name));
    }

    public boolean existsByName(String name) {
        for (Role role : roles) {
            if (role.name.equals(name)) {
                return true;
            }
        }
        return false;
    }
}
