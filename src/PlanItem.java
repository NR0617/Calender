import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanItem {
    public Date planDate;
    public String detail;
    public String people="";
    public static Date getDatefromString(String strDate) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }
    public PlanItem(String date, String detail) {
        this.planDate = getDatefromString(date);
        this.detail = detail;
    }

    public Date getDate() {
        return planDate;
    }
    public void addPeople(String name) {
        people += name + ",";
    }

    public String saveString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String sdate = formatter.format(planDate);
        return sdate + ", "+ "\"" + detail + "\"" + "\n";
    }
}
