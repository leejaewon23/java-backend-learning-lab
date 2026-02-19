package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeOperationExample {
    public void dateOperate() {
        LocalDateTime now3 = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("현재 시간: " + now3.format(dtf));

        LocalDateTime result2 = now3.plusYears(1);
        System.out.println("1년 덧셈: " + result2.format(dtf));

        LocalDateTime result3 = now3.minusMonths(2);
        System.out.println("2월 뺏셈: " +  result3.format(dtf));

        LocalDateTime result4 = now3.plusDays(7);
        System.out.println("7일 덧셈: " +   result4.format(dtf));
    }

}
