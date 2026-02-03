package org.example;

import com.mjc813.machine.Calculator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Calculator carr = new Calculator();
        if ( 60L != carr.add(10, 20, 40)) {
            System.out.println("failed");
        }




    }
}