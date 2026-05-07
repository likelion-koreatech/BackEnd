package class7.repository;

import class7.domain.role.Role;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Repository
public class MemoryMemberRepository implements MemberRepository{

    private Map<String, Role> store = new ConcurrentHashMap<>();

    @Override
    public void save(Role role) {
        store.put(role.getRoleName(), role);
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
    public boolean existsByName(String name) {
        return store.containsKey(name);
    }

    @Override
    public void updateByName(String name, Role member) {
        store.put(name, member);
    }

    @Override
    public boolean deleteByName(String name) {
        if(existsByName(name)){
            store.remove(name);
            return true;
        }
        return false;
    }
}
