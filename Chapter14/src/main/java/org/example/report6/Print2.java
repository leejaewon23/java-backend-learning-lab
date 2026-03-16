package org.example.report6;

public class Print2 implements Runnable {
    private int dan;

    public Print2(String input) {
        // 입력받은 문자열을 숫자로 변환하여 저장
        this.dan = Integer.parseInt(input);
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 9; i++) {
                // 구구단 한 줄 출력
                System.out.println(String.format("%d * %d = %d", dan, i, dan * i));
                // 1초간 대기
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            // 스레드 종료 시 예외 처리
        }
    }
}
