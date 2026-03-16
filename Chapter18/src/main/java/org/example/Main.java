package org.example;

import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //1바이트 출력
        try {
            OutputStream os = new FileOutputStream("output.txt");

            byte a = 10;
            byte b = 20;
            byte c = 30;

            os.write(a);
            os.write(b);
            os.write(c);

            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //바이트 배열 출력
        try {
            OutputStream os = new FileOutputStream("test.db");

            byte[] array = {10, 20, 30};

            os.write(array);

            os.flush();
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            OutputStream os = new FileOutputStream("test3.db");

            byte[] array = {10, 20, 30, 40, 50};

            os.write(array, 1, 3);

            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //바이트 입력 스트림
        try {
            InputStream is = new FileInputStream("test1.db");
        }



    }
}