package org.example;

public class Example {
    public static void action(A a) {
        a.method1();
        if(a instanceof C c) {
            c.method2();
        }
    }
}
