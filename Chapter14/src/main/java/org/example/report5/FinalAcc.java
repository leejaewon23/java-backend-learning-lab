package org.example.report5;

import java.util.List;

public class FinalAcc implements Runnable {
    private List<Integer> list;
    public FinalAcc(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        this.list.stream().sorted().forEach((x) -> {
            System.out.println("ThreadOfPrintASC : " + x );
        });
    }
}
