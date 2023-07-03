import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

public class Calender {
    private static final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private HashMap<Date, PlanItem> planMap;

    public Calender() {
        // 뭔가를 저장할 때 해시맵 또는 해시테이블 이용
        planMap = new HashMap<Date, PlanItem>();
    }

    /*
        @param date ex: "2017-06-20"
        @param plan
     */
    public void registerPlan(String strDate, String plan) {
       // Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
      //  System.out.println(date);
        PlanItem p = new PlanItem(strDate, plan);
        planMap.put(p.getDate(), p); // 일정을 저장
    }

    public PlanItem searchPlan(String strDate) {
        Date date = PlanItem.getDatefromString(strDate);
        return planMap.get(date);
    }

    public boolean isLeapYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public int getMaxDaysOfMonth(int year, int month) {
        if (isLeapYear(year)) {
            return LEAP_MAX_DAYS[month];
        } else {
            return MAX_DAYS[month];
        }
    }

    public void printCalender(int year, int month) {
        System.out.printf("    <<%d년 %d월>>\n", year, month);
        System.out.println(" SUN MON TUE WED THU FRI SAT");
        System.out.println("----------------------------");

        // get weekday automatically
        int weekday = getWeekday(year, month, 1);
        // print blank space
        for (int j = 0; j < weekday; j++) {
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
        for (int i = count + 1; i <= maxDay; i++) {
            System.out.printf("%4d", i);
            if (count < 7 && i % 7 == count) {
                System.out.println();
            }
            if (count == 7 && i % 7 == 0) {
                System.out.println();
            }
        }
    }

    private int getWeekday(int year, int month, int day) {
        // 기준 날짜의 요일?
        int syear = 1970;
        int smonth = 1;
        int sday = 1;
        final int STANDARD_WEEKDAY = 4; // 1970/JAN/1st = Thursday

        int count = 0;

        for (int i = syear; i < year; i++) {
            int delta = isLeapYear(i) ? 366 : 365;
            count += delta;
        }
        //System.out.println(count);

        for (int i = 1; i < month; i++) {
            int delta = getMaxDaysOfMonth(year, i);
            count += delta;
        }

        // count = day -1 안하는 이유는 직접 생각해보세요
        count += day - 1;
//        System.out.println(count);

        int weekday = (count + STANDARD_WEEKDAY) % 7;
        return weekday;
    }

    // simple test code here
    public static void main(String[] args) throws ParseException {
        Calender c = new Calender();
//        c.getWeekday(1970, 5, 1);
//        c.getWeekday(1971, 5, 1);
//        c.getWeekday(1972, 5, 1);
//        c.getWeekday(1973, 5, 1);
        System.out.println(c.getWeekday(1970, 1, 1) == 4);
        System.out.println(c.getWeekday(1971, 1, 1) == 5);
        System.out.println(c.getWeekday(1972, 1, 1) == 6);
        System.out.println(c.getWeekday(1973, 1, 1) == 1);
        System.out.println(c.getWeekday(1974, 1, 1) == 2);

        c.registerPlan("2017-06-23", "Let's eat beef");
        System.out.println(c.searchPlan("2017-06-23").equals(("Let's eat beef")));
    }

}
