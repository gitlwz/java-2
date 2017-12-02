package cn.itcast.path;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/*
如果经常会发生变化的数据我们呢可以定义在配置文件上。比如说：数据库的用户名与密码。

配置文件的路径应该如何写呢？
	
	绝对路径：一个文件的完整路径信息。绝对路径的缺陷：因为绝对路径是盘符开头的，有些系统是没有盘符的。	
	
	相对路径：相对路径是相对于当前程序的路径
	
	类文件路径： 类文件路径就是使用了classpath的路径找对应的资源文件
	
	如果需要使用到类文件路径，首先先要获取到一个Class对象

*/
public class DBUtil {
	
	static Properties properties;
	
	static{
		try {
			properties = new Properties();
			//去加载配置文件
			
			Class clazz = DBUtil.class;
			
			InputStream inputStream = clazz.getResourceAsStream("/db.properties");  // "/"代表了
			
			//properties.load(new FileReader("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println("当前路径: " + new File(".").getAbsolutePath());
		System.out.println("用户名： " + properties.getProperty("userName") + " 密码" + properties.getProperty("password"));
	}

}
