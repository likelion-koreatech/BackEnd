package package1;

import role.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemberRepository {

    private Map<String, Role> store = new ConcurrentHashMap<>();

    // 저장
    public void save(Role role){
        store.put(role.getName(), role);
    }

    // 이름으로 검색
    public Role findByName(String name){
        return store.get(name);
    }

    // 전체 조회
    public List<Role> findAll(){
        return new ArrayList<>(store.values());
    }

    // 이름 중복 확인
    public boolean checkDupl(String name){
        return store.containsKey(name);
    }
}
