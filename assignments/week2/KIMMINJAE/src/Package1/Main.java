package Package1;
import role.Member;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MemberService service = new MemberService();

        while (true) {
            System.out.println("====== 🦁 멤버 관리 시스템 ======");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 종료");
            System.out.print("선택: ");
            int menu = scan.nextInt();
            scan.nextLine();
            if (menu == 1) {
                System.out.println();
                System.out.println("—— 📝 멤버 등록 ——");
                System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
                int role = scan.nextInt();
                scan.nextLine();
                System.out.print("👤 이름: ");
                String name = scan.nextLine();

                if (service.SearchService(name) != null) { // 이름있어!
                    System.out.println("❌ 이미 존재하는 이름입니다.");
                    continue;
                }

                System.out.print("🎓 전공: ");
                String major = scan.nextLine();

                System.out.print("📌 기수: ");
                int rltn = scan.nextInt();
                scan.nextLine();

                System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
                String part = scan.nextLine();


                if (role == 1) {
                    System.out.print("🆔 학번: ");
                    int stuNum = scan.nextInt();
                    scan.nextLine();
                    if (service.registerLion(name, major, rltn, part, stuNum)) {
                        System.out.println("✅ 등록 완료: " + name);
                    }
                }else if (role == 2) {
                        System.out.print("⭐ 직책 (대표/부대표/파트장/멘토): ");
                        String wlrcor = scan.nextLine();
                        if (service.registerStaff(name, major, rltn, part, wlrcor)) {
                            System.out.println("✅ 등록 완료: " + name);
                        }
                    }
                }
                else if(menu == 2) {
                System.out.println("—— 📋 전체 멤버 목록 ——");
                if (service.GetFindAll() == null) {
                    System.out.println("📭 등록된 멤버가 없습니다.");
                } else {
                    int count = 1;
                    for (Member m : service.GetFindAll()) {
                        System.out.println(count + ". [" + m.getRole() + "] " + m.name + " - " + m.getRltn() + "기");
                        count++;
                    }
                    System.out.println("📊 총 " + service.GetFindAll().size() + "명");
                }
            } else if (menu == 3) {
                System.out.println("—— 🔍 이름으로 검색 ——");
                System.out.print("검색할 이름: ");
                String searchName = scan.nextLine();
                Member m = service.SearchService(searchName);
                if (m != null) {
                    m.printInfo();
                } else {
                    System.out.println("❌ 해당 이름의 멤버를 찾을 수 없습니다.");
                }


            } else if (menu == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }


        }

    }
}