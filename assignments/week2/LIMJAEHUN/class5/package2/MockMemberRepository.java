package package2;

import role.Lion;
import role.Role;

import java.util.ArrayList;
import java.util.List;

public class MockMemberRepository implements Repository{

    private List<Role> mockStore = new ArrayList<>();

    public MockMemberRepository(){
        mockStore.add(new Lion("김사자", "컴퓨터공학부",14, "백엔드", 20222022));
    }

    @Override
    public void save(Role role) {
        System.out.println("더미여서 저장 안됨");
    }

    @Override
    public Role findByName(String name) {
        return mockStore.get(0);
    }

    @Override
    public List<Role> findAll() {
        return mockStore;
    }

    @Override
    public boolean checkDupl(String name) {
        return false;
    }
}
