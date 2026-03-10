package org.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientExample {
    public static void main(String[] args) {
        Socket socket = null;
        Scanner scanner = null;
        try {
            //Socket 생성과 동시에 localhost의 50001 Port로 연결 요청;
            socket = new Socket("172.111.121.41", 50001);

            System.out.println(" [클라이언트] 연결 성공");

            scanner = new Scanner(System.in);
            String msg = scanner.nextLine();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write(msg);
            bw.flush();
            //Socket 닫기
            socket.close();
            System.out.println("[클라이언트] 연결 끊음");
            scanner.close();
        } catch ( UnknownHostException e) {
            //IP 표기 방법이 잘못 되었을 경우
        } catch (IOException e) {
            //해당 포트의 서버에 연결할 수 없는 경우
        }
    }

}
