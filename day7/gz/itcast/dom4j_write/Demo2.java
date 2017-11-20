package gz.itcast.dom4j_write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Demo2 {

	public static void main(String[] args) throws DocumentException, IOException {
		Document doc = new SAXReader().read(new File("./day7/contact.xml"));
		
		//三、把修改后的Document对象谢楚道xml文档中
		FileOutputStream out = new FileOutputStream("e:/aa.xml");
		
		//指定写出格式
//		OutputFormat format = OutputFormat.createCompactFormat(); //紧凑的
		OutputFormat format = OutputFormat.createPrettyPrint(); //漂亮的
		/**
		 * 指定生成的编码
		 * 同事印象xml的保存时的编码 和 xml文档生命的encoding的编码
		 * 结论：使用该方法生成的xml文档避免中文乱码问题
		 */
		format.setEncoding("GBK");
		
		XMLWriter writer = new XMLWriter(out,format);
		
		//2.写对象
		writer.write(doc);
		
		//3.关闭流
		writer.close();
	}

}
