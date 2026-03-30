package package2;

import role.Role;

import java.util.ArrayList;
import java.util.List;

public class MemoryMemberRepository implements MemberRepository{

    private List<Role> roles = new ArrayList<>();

    public void save(Role role) {
        roles.add(role);
    }

    public boolean existsByName(String name) {
        for (Role role : roles) {
            if (role.name.equals(name)) {
                return true;
            }
        }
        return false;
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

    public List<Role> findAll() {
        return roles;
    }
}
