import java.util.Scanner;

public class Prompt {
    private final static String PROMPT = "cal> ";

    public void runPrompt() {
        Scanner scanner = new Scanner(System.in);
        Calender cal = new Calender();

        int month = 1;
        int year = 2017;
        while (true) {
            System.out.println("연도를 입력하세요");
            System.out.print(PROMPT);

            year = scanner.nextInt();
            System.out.println("달을 입력하세요");
            System.out.print(PROMPT);

            month = scanner.nextInt();
            if (month == -1) {
                break;
            }
            if (month > 12) {
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
