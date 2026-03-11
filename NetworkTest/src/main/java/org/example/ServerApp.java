package org.example;

//서버소켓 생성(ip대역 option, 포트번호 필수)
//클라이언트 접속 기다리는 동작(블로킹)
//클라이언트 접속이 되면 새로운 데이터소캣/클라이언트통신소켓을 리턴한다.
//새로운 통신 소캣과 클라이언트가 통신하도록 프로그래밍 해야 한다.
//종료시에는 소캣과 자원을 모조리 해제 해야 한다.

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerApp {
    private ServerSocket serverSocket;
    private DataInputStream dis;
    private DataOutputStream dos;

    public ServerApp() throws IOException {
        this.serverSocket = new ServerSocket(59999);
        // 포트번호로 서버소켓을 생성한다.
    }

    public Socket accept() throws IOException {
        return this.serverSocket.accept();
        // 생성된 소켓으로 서버는 클라이언트 연결을 기다린다.
        // 클라이언트 연결이 되면 Socket 객체를 리턴한다.
    }

    public void close() throws IOException {
        this.serverSocket.close();
    }

    public static void main(String[] args) {

        try {
            ServerApp sa = new ServerApp();
            Socket socket = sa.accept();
            // 클라이언트가 연결되면 socket (새로운 클라이언트통신 소켓) 으로 통신이 가능하다.

            String str = "Welcome to the server!";
            socket.getOutputStream().write(str.getBytes(StandardCharsets.UTF_8));
            socket.getOutputStream().flush();
            //서버가 클라이언트에게 데이터를 전송했다.

            byte[] buf = new byte[1024];
            int num = socket.getInputStream().read(buf);
            String msg = new String(buf, 0, num, "UTF-8");
            System.out.println(msg);
            // 클라이언트통신 소켓으로부터 데이터를 읽어서 출력했다.

            socket.close();
            // 클라이언트통신 소켓을 닫았다.

            sa.close();
            // 서버 소켓을 닫았다.

        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }



}
