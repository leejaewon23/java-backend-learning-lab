package org.example;

import ramda.NormalClassRamda;
import ramda.Ramda;
import ramda.RamdaUseInterface;

public class Main {
    public static void main(String[] args) {
        NormalClassRamda nui = new NormalClassRamda();
        nui.doSome();

        RamdaUseInterface lui = new RamdaUseInterface();
        lui.doSome((str, n) -> {
            System.out.println(str.length() == n ?str +  " 같다 " + n : "다르다");
        }, "def", 3);

        lui.doSome((sss, i) -> {
            for (int m = 0; m < i; m++) {
                System.out.print(sss);
            }
            System.out.println();
        }, "def", 3);

    }
}