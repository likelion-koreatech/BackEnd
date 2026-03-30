package package2;

import role.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface Repository {

    // 인터페이스 필드에는 상수만

    // 저장
    public void save(Role role);
    // 이름으로 검색
    public Role findByName(String name);
    // 전체 조회
    public List<Role> findAll();
    // 이름 중복 확인
    public boolean checkDupl(String name);
}
