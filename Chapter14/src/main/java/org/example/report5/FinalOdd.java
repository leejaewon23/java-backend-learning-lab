package org.example.report5;

import java.util.List;

public class FinalOdd implements Runnable {
    private List<Integer> list;
    public FinalOdd(List<Integer> list) {
        this.list = list;
    }
    @Override
    public void run() {
        this.list.stream().filter(x -> x % 2 != 0).forEach((x) -> {
            System.out.println("ThreadOfOdd : " + x );
        });
    }
}
