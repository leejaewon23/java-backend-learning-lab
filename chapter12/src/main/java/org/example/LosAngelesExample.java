package org.example;

import java.util.Calendar;
import java.util.TimeZone;

public class LosAngelesExample {
    public void americas() {
        TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
        Calendar now2 = Calendar.getInstance(timeZone);

        int amPm1 = now2.get(Calendar.AM_PM);
        String strAmPm1 = null;
        if(amPm1 == Calendar.AM) {
            strAmPm1 = "오전";
        } else {
            strAmPm1 = "오후";
        }
        int hour1 = now2.get(Calendar.HOUR);
        int minute1 = now2.get(Calendar.MINUTE);
        int second1 = now2.get(Calendar.SECOND);

        System.out.print(strAmPm1 + " ");
        System.out.print(hour1 + "시 ");
        System.out.print(minute1 + "분 ");
        System.out.println(second1 + "초 ");
    }
}
