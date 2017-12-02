package cn.itcast.path;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/*
��������ᷢ���仯�����������ؿ��Զ����������ļ��ϡ�����˵�����ݿ���û��������롣

�����ļ���·��Ӧ�����д�أ�
	
	����·����һ���ļ�������·����Ϣ������·����ȱ�ݣ���Ϊ����·�����̷���ͷ�ģ���Щϵͳ��û���̷��ġ�	
	
	���·�������·��������ڵ�ǰ�����·��
	
	���ļ�·���� ���ļ�·������ʹ����classpath��·���Ҷ�Ӧ����Դ�ļ�
	
	�����Ҫʹ�õ����ļ�·����������Ҫ��ȡ��һ��Class����

*/
public class DBUtil {
	
	static Properties properties;
	
	static{
		try {
			properties = new Properties();
			//ȥ���������ļ�
			
			Class clazz = DBUtil.class;
			
			InputStream inputStream = clazz.getResourceAsStream("/db.properties");  // "/"������
			
			//properties.load(new FileReader("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println("��ǰ·��: " + new File(".").getAbsolutePath());
		System.out.println("�û����� " + properties.getProperty("userName") + " ����" + properties.getProperty("password"));
	}

}
