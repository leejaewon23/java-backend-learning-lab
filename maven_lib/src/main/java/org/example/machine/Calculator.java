package org.example.machine;

public class Calculator {
    public long add(int ... item) {
        long result = 0L;
        for (int i : item) {
            result += i;
        }
        return result;
    }
}
