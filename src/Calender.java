public class Calender {
    private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int getMaxDaysOfMonth(int month) {
        return MAX_DAYS[month - 1];
    }

    public void printCalender(int year, int month) {
        System.out.printf("    <<%4d년%3d월>>\n", year, month);
        System.out.println(" SUN MON TUE WED THU FRI SAT");
        System.out.println("----------------------------");

        int maxDay = getMaxDaysOfMonth(month);
        for(int i = 1; i <= maxDay; i++) {
            System.out.printf("%4d",i);
            if(i%7 == 0) {
                System.out.println();
            }
        }
    }

}
