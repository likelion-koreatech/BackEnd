package package2;

import role.Lion;
import role.Role;
import role.Staff;

import java.util.ArrayList;
import java.util.List;

public class MockMemberRepository implements MemberRepository{

    private List<Role> roles = new ArrayList<>();

    public MockMemberRepository() {
        roles.add(new Lion("김사자", "컴퓨터공학", 14, "백엔드", "20202020"));
        roles.add(new Staff("김운영", "컴퓨터공학", 13, "프론트엔드", "대표"));
    }

    public void save(Role role) {

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
