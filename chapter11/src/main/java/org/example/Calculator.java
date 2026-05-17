package org.example;

public class Calculator {
    public long add(int ... arrs) {
        long result = 0L;
        for ( int a : arrs ) {
            result += a;
        }
        return result;
    }

    public double divide(int ... arrs) {
        double result = 0.0;
        result = arrs[0];
        for (int i = 1; i < arrs.length; i++) {
            result /= arrs[i];
        }
        return result;
    }
}
