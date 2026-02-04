package org.example;

public class Main {
    public static void main(String[] args) {
        Casher cash = new Casher();
        try {
            cash.calculMoney();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
        finally {
            System.out.println("항상 실행.");
        }


    }
}