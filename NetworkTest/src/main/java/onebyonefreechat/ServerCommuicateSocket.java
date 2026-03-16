package onebyonefreechat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerCommuicateSocket {
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;

	public ServerCommuicateSocket(Socket socket) throws IOException {
		this.socket = socket;
//		this.dis = new ~~~~;    코딩하세요
        this.dis = new DataInputStream(socket.getInputStream());
//		this.dos = new ~~~~;    코딩하세요
        this.dos = new DataOutputStream(socket.getOutputStream());
	}

	public void send(String msg) {
		// this.dos 를 이용하여 msg 를 전송하는 코딩 하세요
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
        }


	}

	public String read() throws IOException {
		String str = "";
		// this.dis 를 이용하여 InputStream 문자를 읽어서 str 에 리턴하는 코딩 하세요.
        str = this.dis.readUTF();
		return str;
	}

	public void close() {
		try {
			this.dos.close();
		} catch (Exception e) {
		}
		try {
			this.dis.close();
		} catch (Exception e) {
		}
		try {
			this.socket.close();
		} catch (Exception e) {
		}
	}
}
