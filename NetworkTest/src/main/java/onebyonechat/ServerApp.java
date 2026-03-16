package onebyonechat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

//	ServerApp 과 ClientApp 을 ClientApp 먼저 데이터를 보내고 받는 순서로 하되
//	데이터는 키보드에서 입력 받아서 보내는것으로 수정해 보세요.
//	이 소스를 onebyonechat 패키지에 생성하세요

public class ServerApp {
    private static ServerSocket serverSocket;
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

    public static void main(String[] args) throws Exception{
        startServer();

    }

    public static void startServer() throws Exception {
        Thread thread = new Thread() {
            public void run() {
                try {
                    onebyonechat.ServerApp sa = new onebyonechat.ServerApp();

                    while (true) {
                        System.out.println("Waiting for connection...");
                        Socket socket = serverSocket.accept();

                        String str = "Welcome to the server!";
                        socket.getOutputStream().write(str.getBytes(StandardCharsets.UTF_8));
                        socket.getOutputStream().flush();
                        //서버가 클라이언트에게 데이터를 전송했다.

                        byte[] buf = new byte[1024];
                        int num = socket.getInputStream().read(buf);
                        String msg = new String(buf, 0, num, "UTF-8");
                        System.out.println(msg);

                        socket.close();;
                        System.out.println("연결을 끊음");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }


}
