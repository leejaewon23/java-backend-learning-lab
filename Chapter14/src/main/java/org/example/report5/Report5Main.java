package org.example.report5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Report5Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            String[] split = input.split(",");
            int[] intArray = Arrays.asList(split).stream().mapToInt(Integer::parseInt).toArray();
            List<Integer> list = Arrays.stream(intArray).boxed().collect(Collectors.toList());

            Thread FinalSum = new Thread(new FinalHap(list));
            Thread FinalAvg = new Thread(new FinalAvg(list));
            Thread FinalOdd = new Thread(new FinalOdd(list));
            Thread FinalAcc = new Thread(new FinalAcc(list));
            Thread FinalDesc = new Thread(new FinalDesc(list));
            FinalSum.start();
            FinalAvg.start();
            FinalOdd.start();
            FinalAcc.start();
            FinalDesc.start();
            

        }
    }
}
