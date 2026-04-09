package likelion.class6.repository;



import likelion.class6.role.Role;

import java.util.List;

public interface MemberRepository {

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
