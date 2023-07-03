import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

    public void printMenu() {
        System.out.println("+-------------------------+");
        System.out.println("| 1. 일정 등록");
        System.out.println("| 2. 일정 검색");
        System.out.println("| 3. 달력 보기");
        System.out.println("| h. 도움말  q. 종료");
        System.out.println("+-------------------------+");
    }

    //    @param week 요일명
//    @return 0~6 (0: SUNDAY, 6:SATURDAY)
    public int parseDay(String week) {
        switch (week) {
            case "SUN":
                return 0;
            case "MON":
                return 1;
            case "TUE":
                return 2;
            case "WED":
                return 3;
            case "THU":
                return 4;
            case "FRI":
                return 5;
            case "SAT":
                return 6;
            default:
                return 0;
        }

//        if (week.equals("SUN")) return 0;
//        else if (week.equals("MON")) return 1;
//        else if (week.equals("TUE")) return 2;
//        else if (week.equals("WED")) return 3;
//        else if (week.equals("THU")) return 4;
//        else if (week.equals("FRI")) return 5;
//        else if (week.equals("SAT")) return 6;
//        else return 0;
    }

    public void runPrompt() throws ParseException {
        printMenu();

        Scanner scanner = new Scanner(System.in);
        Calender cal = new Calender();

        boolean isLoop = true;
        while (isLoop) {
            System.out.println("명령 (1, 2, 3, h, q )");
            String cmd = scanner.next();
            switch (cmd) {
                case "1":
                    cmdRegister(scanner, cal);
                    break;
                case "2":
                    cmdSearch(scanner, cal);
                    break;
                case "3":
                    cmdCal(scanner, cal);
                    break;
                case "h":
                    printMenu();
                case "q":
                    isLoop = false;
                    break;
            }
//            if (cmd.equals("1")) {
//                cmdRegister(scanner, cal);
//            } else if (cmd.equals("2")) {
//                cmdSearch(scanner, cal);
//            } else if (cmd.equals("3")) {
//                cmdCal(scanner, cal);
//            } else if (cmd.equals("h")) {
//                printMenu();
//            } else if (cmd.equals("q")) {
//                break;
//            }

        }
            System.out.println("Bye~");
            scanner.close();

    }
    private void cmdCal(Scanner s, Calender c) {
        int month = 1;
        int year = 2017;

        System.out.println("연도를 입력하세요.");
        System.out.print("Year >");
        year = s.nextInt();

        System.out.println("달을 입력하세요");
        System.out.print("Month >");
        month = s.nextInt();


        if (month > 12 || month < 1) {
            System.out.println("잘못된 입력입니다.");
            return;
        }
        c.printCalender(year, month); // 참조를 넘겨주는 것
        System.out.printf("\n%d월은 %d일까지 있습니다.\n", month, c.getMaxDaysOfMonth(year, month));
    }


    private void cmdSearch(Scanner s, Calender c) throws ParseException {
        System.out.println();
        System.out.println("날짜를 입력해 주세요(\"yyyy-mm-dd\")");
        String date = s.next();
        PlanItem plan;
        plan = c.searchPlan(date);
        if(plan != null) {
            System.out.println(plan.detail);
        } else {
            System.out.println("일정이 없습니다.");
        }
    }

    private void cmdRegister(Scanner s, Calender c) throws ParseException {
        System.out.println("날짜를 입력해 주세요(\"yyyy-mm-dd\")");
        String date = s.next();
        String text = "";
        System.out.println("일정을 입력해주세요(문장의 끝에 ;을 입력해주세요)");
//        String text = s.nextLine(); -> 문장을 잘 받아오지 못하네요
        String word;
        while (true) {
            word = s.next();
            if (word.endsWith(";")) {
                break;
            }
            text += word + " ";
        }
        text += word.replace(";","");

        c.registerPlan(date, text);
    }

    public static void main(String[] args) throws ParseException {
        // 셀 실행
        Prompt p = new Prompt();
        p.runPrompt();
    }
}
