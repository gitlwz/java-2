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
		// һ����ȡ�򴴽�һ��Document����
		//��ȡday07��Ŀ��xm�ļ�
		Document doc = new SAXReader().read(new File("./day7/contact.xml"));
		
		
		//�����޸�Document����
		
		
		
		
		
		
		//�������޸ĺ��Document����л����xml�ĵ���
		FileOutputStream out = new FileOutputStream("e:/aa.xml");
		//����д������
		XMLWriter writer = new XMLWriter(out);
		
		//2.д����
		writer.write(doc);
		
		//3.�ر���
		writer.close();
	}
}
