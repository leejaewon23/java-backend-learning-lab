package org.example.report2;

public class GuGuDan2 {
    public static void main(String[] args) throws InterruptedException {
        GuGuDan5to9 gg59 = new GuGuDan5to9();
        gg59.start();

        for ( int dan = 2; dan <= 4; dan++ ) {
            for ( int number = 1; number <= 9; number++ ) {
                System.out.println(String.format("%d * %d = %d", dan, number, dan*number));
                Thread.sleep(50);
            }
        }
    }

}
