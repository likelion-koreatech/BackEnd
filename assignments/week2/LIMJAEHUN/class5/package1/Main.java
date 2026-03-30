package package1;

import role.Lion;
import role.Role;
import role.Staff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemberService memberService = new MemberService();

        while(true){
            menu();

            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose){
                case 1:
                    register(sc, memberService);
                    break;
                case 2:
                    findAll(memberService);
                    break;
                case 3:
                    findByName(sc, memberService);
                    break;
                case 4:
                    System.out.println("프로그램 종료");
                    return;
            }
        }
    }

    private static void findByName(Scanner sc, MemberService memberService) {
        System.out.println("==== 이름으로 검색 ====");
        System.out.printf("검색할 이름 : ");
        String name = sc.nextLine();
        Role result = memberService.getMemberByName(name);
        if(result != null){
            result.showRole();
        } else{
            System.out.println("등록되지 않은 이름입니다.");
        }
    }

    private static void findAll(MemberService memberService) {
        int i=1;
        System.out.println("==== 전체 멤버 조회 ====");
        for(Role r : memberService.getAllMember()){
            System.out.printf("%d.", i++);
            System.out.println(" "+ r.getName());
        }
    }

    // 메뉴
    private static void menu(){
        System.out.println("==== 멤버 관리 시스템 ====");
        System.out.println("1. 멤버 등록");
        System.out.println("2. 전체 멤버 조회");
        System.out.println("3. 이름으로 검색");
        System.out.println("4. 종료");
    }

    // 1. 멤버 등록
    private static void register(Scanner sc, MemberService memberService){
        System.out.print("역할 선택 (1: 아기사자, 2: 운영진) :");
        int num = sc.nextInt();
        sc.nextLine();

        if(num == 1){
            Role target = registerLion(sc);
            if (memberService.register(target)){
                System.out.println("등록 완료 : " + target.getName());
            } else{
                System.out.println("등록 실패");
            }
        }
        else if(num == 2){
            if (memberService.register(registerStaff(sc))){
                System.out.println("등록 완료");
            } else{
                System.out.println("등록 실패");
            }
        }


    }

    private static Role registerLion(Scanner sc) {
        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("전공 : ");
        String major = sc.nextLine();
        System.out.print("기수 : ");
        int cohort = sc.nextInt();
        sc.nextLine();
        System.out.print("파트 (백엔드/프론트엔드/기획/디자인) : ");
        String part = sc.nextLine();
        System.out.print("학번 : ");
        int id = sc.nextInt();
        sc.nextLine();
        return new Lion(name, major, cohort, part, id);
    }

    private static Role registerStaff(Scanner sc) {
        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("전공 : ");
        String major = sc.nextLine();
        System.out.print("기수 : ");
        int cohort = sc.nextInt();
        sc.nextLine();
        System.out.print("파트 (백엔드/프론트엔드/기획/디자인) : ");
        String part = sc.nextLine();
        System.out.print("직책(대표 / 운영진) : ");
        String position = sc.nextLine();
        return new Staff(name, major, cohort, part, position);
    }

}