package org.example.report2;

public class GuGuDan5to9 extends Thread {
    public  void run () {
        for ( int dan = 2; dan <= 9; dan++ ) {
            for ( int number = 1; number <= 9; number++ ) {
                System.out.println(String.format("%d * %d = %d", dan, number, dan*number));
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
