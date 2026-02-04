package org.example;

public class Casher {
    public void calculMoney (int ... arrs) {
        Caculator cal = new Caculator();
        double res = cal.divide(arrs);
        System.out.println("res= " + res);

    }
}
