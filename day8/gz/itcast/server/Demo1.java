package gz.itcast.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		//����serverSocket
		ServerSocket server = new ServerSocket(8888);
		
		System.out.println("aaaaa");
		
		//2.���ܿͻ��˵�����
		Socket socket = server.accept();
		
		//3.��ȡ���ص�test.html�ļ�
		FileInputStream inputStream = new FileInputStream(new File("F:/�½��ļ���/fileceshi/test.html"));
		
		
		//4.�������ݵ����ͨ��
		OutputStream out = socket.getOutputStream();
		
		//5.��������
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = inputStream.read(buf)) != -1){
			out.write(buf,0,len);
		}
		
		//6.�ر���Դ
		out.close();
		inputStream.close();
		
	}

}
