package org.example.report3;

public class GuGuDan4to6 implements Runnable {
    @Override
    public void run() {
            for ( int dan = 4; dan <= 6; dan++ ) {
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

