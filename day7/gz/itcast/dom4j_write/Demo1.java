package gz.itcast.dom4j_write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 
 * @author 54748
 *
 */



public class Demo1 {
	public static void main(String[] args) throws DocumentException, IOException {
		// 一、读取或创建一个Document对象
		//读取day07项目的xm文件
		Document doc = new SAXReader().read(new File("./day7/contact.xml"));
		
		
		//二、修改Document对象
		
		
		
		
		
		
		//三、把修改后的Document对象谢楚道xml文档中
		FileOutputStream out = new FileOutputStream("e:/aa.xml");
		//创建写出对象
		XMLWriter writer = new XMLWriter(out);
		
		//2.写对象
		writer.write(doc);
		
		//3.关闭流
		writer.close();
	}
}
