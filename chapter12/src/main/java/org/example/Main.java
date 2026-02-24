package org.example;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BoxingUnBoxingExample b1 = new BoxingUnBoxingExample();
        b1.boxingUn();


        ValueCompareExample v1 = new ValueCompareExample();
        v1.valueCompare();

        MathExample m1 = new MathExample();
        m1.mathIsgood();

        RandomExample r1 = new RandomExample();
        r1.rottoNumber();

        //날짜와 시간 클래스
        DateExample d1 = new DateExample();
        d1.dateTo();

        CalendarExample c1 = new CalendarExample();
        c1.calendarDays();

        LosAngelesExample l1 = new LosAngelesExample();
        l1.americas();



        //날씨와 시간 조작
        PrintTimeZoneID i1 = new PrintTimeZoneID();
        i1.printZoneID();

        DateTimeOperationExample o1 = new DateTimeOperationExample();
        o1.dateOperate();

        //날짜와 시간 비교
        DateTimeCompareExample o2 = new DateTimeCompareExample();
        o2.timeCompare();

        //형식 클래스(DecimalFormat)
        DecimalFormatExample df1 = new DecimalFormatExample();
        df1.format();

        //SimpleDateFormat
        SimpleDateFormatExample sdf1 = new SimpleDateFormatExample();
        sdf1.dateFormat();

        //정규 표현식 클래스
        PatternExample p1 = new PatternExample();
        p1.pattern();

        //리플렉션
        GetClassExample g1 = new GetClassExample();
        g1.getIsClass();

        ReflectionExample r = new ReflectionExample();
        r.reflect();

//        GetResourceExample g2 = new GetResourceExample();
//        g2.resource();

        //어노테이션
        PrintAnnotationExample p2 = new PrintAnnotationExample();
        p2.annotation();

        //확인문제 5번

        //Student를 저장하는 HashSet 생성
        HashSet<Student> hashSet = new HashSet<Student>();

        //Student 저장
        hashSet.add(new Student("1"));
        hashSet.add(new Student("1"));
        hashSet.add(new Student("2"));

        //저장된 Student 수 출력
        System.out.println("저장된 Student 수: " + hashSet.size());

        //확인문제 6번
        Member member = new Member("blue", "이파란");
        System.out.println(member);











    }



    }
