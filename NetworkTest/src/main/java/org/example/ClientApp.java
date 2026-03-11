package org.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientApp {
    private Socket socket;

    public ClientApp() throws IOException {
        this.socket = new Socket(); // 클라이언트의 통신용 소켓 생성
    }

    public void connect() throws IOException {
//        this.socket.bind(new InetSocketAddress("localhost", 59999));
        this.socket.connect(new InetSocketAddress("localhost", 59999));
        // 해당 ip 와 포트로 접속을 시도한다.
    }

    public void close() throws IOException {
        this.socket.close();
        // 클라이언트 통신 소켓을 닫는다.
    }

    public String read() {
        String data = null;
        try {
            byte[] buf = new byte[1024];
            int count = this.socket.getInputStream().read(buf);
            data = new String(buf, 0, count, "UTF-8");
        } catch (IOException e) {
            System.err.println("데이터 입력 받을 수 없습니다.");
        }
        return data;
    }

    public void send(String msg) {
        try {
            byte[] buf = msg.getBytes(StandardCharsets.UTF_8);
            this.socket.getOutputStream().write(buf);
            this.socket.getOutputStream().flush();
        } catch (Exception ex) {}
    }

    public static void main(String[] args) {
        try {
            ClientApp ca = new ClientApp();
            ca.connect();

            String msg = ca.read();
            System.out.println("Server: " + msg);

            ca.send("반갑습니다");
            ca.close();

        } catch (Exception ex) {
            System.err.println(ex.toString());
        }

    }
}
