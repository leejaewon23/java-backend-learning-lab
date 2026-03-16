package org.example.report3;

public class GuGuDan3 {
    public static void main(String[] args) throws InterruptedException {
        GuGuDan4to6 gg46  = new GuGuDan4to6();
        Thread gg79 = new Thread(new GuGUDan7to9());

        gg46.run();
        gg79.start();

        for ( int dan = 2; dan <= 3; dan++ ) {
            for ( int number = 1; number <= 9; number++ ) {
                System.out.println(String.format("%d * %d = %d", dan, number, dan*number));
                Thread.sleep(50);
            }
        }
    }
}
