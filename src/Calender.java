public class Calender {
    private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public boolean isLeapYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public int getMaxDaysOfMonth(int year, int month) {
        if (isLeapYear(year)) {
            return LEAP_MAX_DAYS[month - 1];
        } else {
            return MAX_DAYS[month - 1];
        }
    }

    public void printCalender(int year, int month, int weekday) {
        System.out.printf("    <<%4d년%3d월>>\n", year, month);
        System.out.println(" SUN MON TUE WED THU FRI SAT");
        System.out.println("----------------------------");

        // print blank space
        for(int j = 0; j < weekday; j++) {
            System.out.print("    ");
        }

        int maxDay = getMaxDaysOfMonth(year, month);
        int count = 7 - weekday;

        // print first line
        for (int k = 1; k <= count; k++) {
            System.out.printf("%4d", k);
        }
        System.out.println();

        // print from second to last line
        for (int i = count+1; i <= maxDay; i++) {
            System.out.printf("%4d", i);
            if (count < 7 && i % 7 == count) {
                System.out.println();
            }
            if (count == 7 && i % 7 == 0) {
                System.out.println();
            }
        }
    }

}
