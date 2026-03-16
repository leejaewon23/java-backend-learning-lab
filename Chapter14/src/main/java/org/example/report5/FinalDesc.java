package org.example.report5;

import java.util.Comparator;
import java.util.List;

public class FinalDesc implements Runnable {
    private List<Integer> list;
    public FinalDesc(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        this.list.stream()
                .filter(x -> x % 2 == 0)
                .sorted(Comparator.reverseOrder())
                .forEach((x) -> {
                    System.out.println("ThreadOfPrintDescEven : " + x );
                });
    }
}
