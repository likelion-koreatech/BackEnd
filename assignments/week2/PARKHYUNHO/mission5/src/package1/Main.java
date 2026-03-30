package package1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MemberRepository memberRepository = new MemberRepository();
        MemberService memberService = new MemberService(memberRepository);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("==== 멤버 관리 시스템 ====");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 종료");
            System.out.print("선택: ");
            int input = Integer.parseInt(scanner.nextLine());

            switch (input) {
                case 1 -> {
                    memberService.save(scanner);
                }
                case 2 -> {
                    memberService.findAll();
                }
                case 3 -> {
                    memberService.findByName(scanner);
                }
                case 4 -> {
                    return;
                }
            }
        }
    }
}
