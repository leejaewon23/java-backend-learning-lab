package org.example.report4;

import java.security.Key;
import java.util.Scanner;

public class Keyboard {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        Thread th = null;
        while (true) {
            String input = sc.nextLine();
            if (th != null) {
                th.interrupt();
            }
            th = new Thread(new Print(input));
            th.start();
        }

    }
}
