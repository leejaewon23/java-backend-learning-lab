package org.example;

import javax.naming.InsufficientResourcesException;

import static org.example.ExceptionHandlingExample1.printLength;

public class Main {
    public static void main(String[] args)  {
        Cashier cash = new Cashier();
        try {
            cash.calculMoney();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
        finally {
            System.out.println("항상 실행.");
        }


        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        printLength(null);
        System.out.println("[프로그램 종료]");

        try {
            Class.forName("java.lang.String");
            System.out.println("java.lang.String 클래스가 존재합니다.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println();

        try {
            Class.forName("java.lang.String2");
            System.out.println("java.lang.String2 클래스가 존재합니다.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String[] array = {"100", "1oo", null, "200"};

        for (int i = 0; i <= array.length; i++) {
            try {
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "]: " + value);
            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("배열 인덱스가 초과됨: " + e.getMessage());
            } catch(NullPointerException | NumberFormatException e) {
                System.out.println("데이터에 문제가 있음." + e.getMessage());
            }
        }

        // 11.4 리소스 자동 닫기
        try (MyResource res = new MyResource("A")) {
            String data = res.read1();
            int value1 = Integer.parseInt(data);
        } catch (Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }

        System.out.println();

        try (MyResource res = new MyResource("A")) {
            String data = res.read2();
            //NumberFormatException 발생
            int value1 = Integer.parseInt(data);
        } catch (Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }

        System.out.println();

        MyResource res1 = new MyResource("A");
        MyResource res2 = new MyResource("B");
        try (res1; res2) {
            String data3 = res1.read1();
            String data4 = res2.read2();
        } catch (Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }
        // 11.5 예외 떠넘기기
        try {
            findClass();
        } catch(ClassNotFoundException e) {
            System.out.println("예외 처리: " + e.getMessage());
        }

        //11.6 사용자 정의 예외
        Account account = new Account();
        //예금하기
        account.deposit(10000);
        System.out.println("예금액: " + account.getBalance());

        //출금하기
        try {
            account.withdraw(30000);
        } catch(InsufficientResourcesException e) {
            String message = e.getMessage();
            System.out.println(message);
        }
    }
    public static void findClass() throws ClassNotFoundException {
        Class.forName("java.lang.String2");
    }

}
