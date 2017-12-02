package gz.itcast.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		//创建serverSocket
		ServerSocket server = new ServerSocket(8888);
		
		System.out.println("aaaaa");
		
		//2.接受客户端的链接
		Socket socket = server.accept();
		
		//3.读取本地的test.html文件
		FileInputStream inputStream = new FileInputStream(new File("F:/新建文件夹/fileceshi/test.html"));
		
		
		//4.构建数据的输出通道
		OutputStream out = socket.getOutputStream();
		
		//5.发送数据
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = inputStream.read(buf)) != -1){
			out.write(buf,0,len);
		}
		
		//6.关闭资源
		out.close();
		inputStream.close();
		
	}

}
