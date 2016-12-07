package fi.harism.curl;

/**
 * Created by zhangshuqing on 16/12/7.
 */
public class CalendarEntry {
    private String month;
    private String day;
    private String week;

    public CalendarEntry(){}

    public CalendarEntry(String month, String day, String week) {
        this.month = month;
        this.day = day;
        this.week = week;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
}
