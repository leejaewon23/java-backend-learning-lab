package org.example;

import java.util.Calendar;

public class CalendarExample {
    public void calendarDays() {
        //Calendar 클래스
        Calendar now1 = Calendar.getInstance();

        int year = now1.get(Calendar.YEAR);
        int month = now1.get(Calendar.MONTH);
        int day = now1.get(Calendar.DAY_OF_MONTH);
        int week = now1.get(Calendar.DAY_OF_WEEK);
        String strWeek = null;
        switch(week) {
            case Calendar.MONDAY:   strWeek = "월";  break;
            case Calendar.TUESDAY:  strWeek = "화";  break;
            case Calendar.WEDNESDAY:strWeek = "수";  break;
            case Calendar.THURSDAY: strWeek = "목";  break;
            case Calendar.FRIDAY:   strWeek = "금";  break;
            case Calendar.SATURDAY: strWeek = "토";  break;
            default:                strWeek = "일";
        }

        int amPm = now1.get(Calendar.AM_PM);
        String strAmPm = null;
        if(amPm == Calendar.AM) {
            strAmPm = "오전";
        } else {
            strAmPm = "오후";
        }
        int hour = now1.get(Calendar.HOUR);
        int minute = now1.get(Calendar.MINUTE);
        int second = now1.get(Calendar.SECOND);

        System.out.print(year + "년 ");
        System.out.print(month + "월 ");
        System.out.println(day + "일");
        System.out.print(strWeek + "요일 ");
        System.out.println(strAmPm + " ");
        System.out.print(hour + "시 ");
        System.out.print(minute + "분");
        System.out.println(second + "초 ");

    }
}
