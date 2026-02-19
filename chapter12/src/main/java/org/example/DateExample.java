package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {
    public void dateTo() {
        //Date 클래스
        Date now = new Date();
        String strNow1 = now.toString();
        System.out.println(strNow1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strNow2 = sdf.format(now);
        System.out.println(strNow2);
    }
}
