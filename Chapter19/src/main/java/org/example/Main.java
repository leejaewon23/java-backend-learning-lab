package org.example;

import lombok.Getter;
import lombok.ToString;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;
import java.net.ServerSocket;
import java.net.Socket;

@Getter
@ToString



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static ServerSocket serverSocket = null;
    public static void main(String[] args) {

        try {
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("내 컴퓨터 IP 주소: " + local.getHostAddress());

            InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
            for(InetAddress remote : iaArr) {
                System.out.println("www.naver.com IP 주소: " + remote.getHostAddress());
            }
        } catch(UnknownHostException e) {
            e.printStackTrace();
        }

        //TCP 네트워킹
        System.out.println("--------------------------------------");
        System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 Enter 키를 입력하세요.");
        System.out.println("--------------------------------------");


        //TCP 서버 시작
        startServer();

        //키보드 입력
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String key = scanner.nextLine();
            if(key.toLowerCase().equals("q")) {
                break;
            }
        }
        scanner.close();

        //TCP 서버 종료
        stopServer();

        try {
            //Socket 생성과 동시에 localhost의 50001 Port로 연결 요청;
            Socket socket = new Socket("localhost", 50001);

            System.out.println(" [클라이언트] 연결 성공");

            //Socket 닫기
            socket.close();
            System.out.println("[클라이언트] 연결 끊음");
        } catch ( UnknownHostException e) {
            //IP 표기 방법이 잘못 되었을 경우
        } catch (IOException e) {
            //해당 포트의 서버에 연결할 수 없는 경우
        }



    }

    public static void startServer() {
        //작업 스레드 정의
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    //ServerSocket 생성 및 Port 바인딩
                    serverSocket = new ServerSocket(50001);
                    System.out.println("[서버] 시작됨");

                    while (true) {
                        System.out.println( "\n[서버] 연결 요청을 기다림\n");
                        //연결 수락
                        Socket socket = serverSocket.accept();

                        //연결된 클라이언트 정보 얻기
                        InetSocketAddress isa =
                                (InetSocketAddress) socket.getRemoteSocketAddress();
                        System.out.println("[서버]" + isa.getHostString() + "의 연결 요청을 수락함");

                        //연결 끊기
                        socket.close();
                        System.out.println("[서버] " + isa.getHostString() + "의 연결을 끊음");
                    }
                } catch (IOException e) {
                    System.out.println("[서버] " + e.getMessage());
                }
            }
        };
        //스레드 시작
        thread.start();
    }
    public static void stopServer() {
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
                System.out.println("[서버] 종료됨");
            }
        } catch (IOException e1) {}
    }
}