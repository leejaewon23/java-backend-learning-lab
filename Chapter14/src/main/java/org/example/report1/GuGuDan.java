package org.example.report1;

public class GuGuDan {
    public static void main(String[] args) throws InterruptedException {
        for ( int dan = 2; dan <= 9; dan++ ) {
            for ( int number = 1; number <= 9; number++ ) {
                System.out.println(String.format("%d * %d = %d", dan, number, dan*number));
                Thread.sleep(100);
            }
        }
    }
}
