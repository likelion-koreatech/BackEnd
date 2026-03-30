package package1;

import role.Lion;
import role.Role;
import role.Staff;

import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void save(Scanner scanner) {
        System.out.println("-- 멤버 등록 --");
        System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
        int roleNum = Integer.parseInt(scanner.nextLine());
        System.out.print("이름: ");
        String name = scanner.nextLine();
        if (memberRepository.existsByName(name)) {
            System.out.println("등록 실패: 이미 존재하는 이름입니다.");
            return;
        }
        System.out.print("전공: ");
        String major = scanner.nextLine();
        System.out.print("기수: ");
        int batch = Integer.parseInt(scanner.nextLine());
        System.out.print("파트 (백엔드/프론트엔드/기획/디자인): ");
        String part = scanner.nextLine();
        if (roleNum == 1) {
            System.out.print("학번: ");
            String stuId = scanner.nextLine();
            Lion lion = new Lion(name, major, batch, part, stuId);
            memberRepository.save(lion);
        } else if (roleNum == 2) {
            System.out.print("직책 (대표/부대표/파트장/멘토): ");
            String role = scanner.nextLine();
            Staff staff = new Staff(name, major, batch, part, role);
            memberRepository.save(staff);
        }
    }

    public void findAll() {
        System.out.println("-- 전체 멤버 목록 --");
        int i = 0;
        List<Role> roles = memberRepository.findAll();
        for (Role role : roles) {
            if (role.isLion()) {
                System.out.println("[아기사자] " + role.name
                        + " - " + role.batch + "기");
            } else {
                System.out.println("[운영진] " + role.name
                        + " - " + role.batch + "기");
            }
            i++;
        }
        System.out.println("총 " + roles.size() + "명");
    }

    public void findByName(Scanner scanner) {
        System.out.println("-- 이름으로 검색 --");
        System.out.print("검색할 이름: ");
        String name = scanner.nextLine();
        Role role = memberRepository.findByName(name);
        if (role == null) {
            System.out.println("등록된 멤버가 없습니다.");
            return;
        }
        System.out.println(role.information());
    }
}
