package org.example.report6;

import java.util.Scanner;

import java.util.Scanner;

public class Report6Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String input = sc.nextLine();

            try {
                int num = Integer.parseInt(input);
                if (num >= 2 && num <= 9) {
                    // 이전 스레드를 관리(th.interrupt)하지 않고 바로 새 스레드 시작
                    Thread th = new Thread(new Print2(input));
                    th.start();
                } else {
                    System.out.println("2에서 9 사이의 숫자만 입력해주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }
}
