package likelion.class6.repository;



import likelion.class6.role.Role;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private Map<String, Role> store = new ConcurrentHashMap<>();

    @Override
    public void save(Role role) {
        store.put(role.getName(), role);
    }

    @Override
    public Role findByName(String name) {
        return store.get(name);
    }

    @Override
    public List<Role> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public boolean checkDupl(String name) {
        return store.containsKey(name);
    }
}
