import java.util.Scanner;

public class Prompt {
//    private final static String PROMPT = "cal> ";
// @param week 요일명
//  @return 0~6 (0: SUNDAY, 6:SATURDAY)
    public int parseDay(String week) {
        if (week.equals("SUN")) return 0;
        else if(week.equals("MON")) return 1;
        else if(week.equals("TUE")) return 2;
        else if(week.equals("WED")) return 3;
        else if(week.equals("THU")) return 4;
        else if(week.equals("FRI")) return 5;
        else if(week.equals("SAT")) return 6;
        else return 0;
    }

    public void runPrompt() {
        Scanner scanner = new Scanner(System.in);
        Calender cal = new Calender();

        int month = 1;
        int year = 2017;

        while (true) {
            System.out.println("연도를 입력하세요. exit: -1");
            System.out.print("Year >");
            year = scanner.nextInt();
            if(year == -1)
                break;

            System.out.println("달을 입력하세요");
            System.out.print("Month >");
            month = scanner.nextInt();


            if (month > 12 || month < 1) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }
            cal.printCalender(year, month);
            System.out.printf("\n%d월은 %d일까지 있습니다.\n", month, cal.getMaxDaysOfMonth(year, month));
        }

        System.out.println("Bye~");
        scanner.close();
    }

    public static void main(String[] args) {
    // 셀 실행
        Prompt p = new Prompt();
        p.runPrompt();
    }
}
