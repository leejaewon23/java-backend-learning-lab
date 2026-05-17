package org.example;

public class Cashier {
    public void calculMoney (int ... arrs) {
        Calculator cal = new Calculator();
        double res = cal.divide(arrs);
        System.out.println("res= " + res);

    }
}
