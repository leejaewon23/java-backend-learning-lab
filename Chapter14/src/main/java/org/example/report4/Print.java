package org.example.report4;

public class Print implements Runnable {
    private String ch;
    public Print(String ch) {
        this.ch = ch;
    }
    @Override
    public void run() {
            while (true) {
                try {
                    System.out.println(ch);
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    System.out.println("종료");
                    break;
                }
            }
        }

    }

