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
		
		//�������޸ĺ��Document����л����xml�ĵ���
		FileOutputStream out = new FileOutputStream("e:/aa.xml");
		
		//ָ��д����ʽ
//		OutputFormat format = OutputFormat.createCompactFormat(); //���յ�
		OutputFormat format = OutputFormat.createPrettyPrint(); //Ư����
		/**
		 * ָ�����ɵı���
		 * ͬ��ӡ��xml�ı���ʱ�ı��� �� xml�ĵ�������encoding�ı���
		 * ���ۣ�ʹ�ø÷������ɵ�xml�ĵ�����������������
		 */
		format.setEncoding("GBK");
		
		XMLWriter writer = new XMLWriter(out,format);
		
		//2.д����
		writer.write(doc);
		
		//3.�ر���
		writer.close();
	}

}
