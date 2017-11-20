package gz.itcast.dom4j_write;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;
import org.xml.sax.DocumentHandler;

/**
 * �޸�xml����
 * ���ӣ���ǩ������
 * �޸ģ�����ֵ���ı�
 * ɾ������ǩ������
 * 
 * 
 * @author 54748
 *
 */
public class Demo3 {
	
	public static void main(String[] args) {
		
	}
	
	
	@Test
	public void test1Name() throws Exception {
		// һ����ȡ�򴴽�һ��Document����
		//�����ĵ�
		Document doc = DocumentHelper.createDocument();
		
		//2.���ӱ�ǩ
		Element rootelElement = doc.addElement("contactList");
		Element contractelElement = rootelElement.addElement("contact");
		contractelElement.addElement("name");
		
		//3.�������
		contractelElement.addAttribute("id", "001");
		contractelElement.addAttribute("name", "lwz");
		//�����޸�Document����
		
		
		
		
		
		
		//�������޸ĺ��Document����л����xml�ĵ���
		FileOutputStream out = new FileOutputStream("e:/aa.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doc);
		writer.close();
	}
	
	@Test
	public void test2Name() throws Exception {
		// һ����ȡ�򴴽�һ��Document����
		Document doc = new SAXReader().read(new File("./day7/contact.xml"));
		
		
		//�����޸�Document����
		
		// ����һ���޸�����ֵ    
		//�õ���ǩ���� ->�õ����Զ��� -> �޸�����ֵ
		//1.1�õ���ǩ����
		Element contactelement = doc.getRootElement().element("contact");
		
		//1.2�õ����Զ���
		Attribute idaAttribute = contactelement.attribute("id");
		
		//1.3�޸�����ֵ
		idaAttribute.setValue("aaaaa");
		
		//���������޸�����ֵ
		//1.1�õ���ǩ����
		Element contactElement2 = doc.getRootElement().element("contact");
		
		//1.2ͨ������ͬ�����Եķ���,�޸�����ֵ
		contactElement2.addAttribute("id","0004");
		
		
		/**
		 * �޸��ı�     �õ���ǩ���� -> �޸��ı�
		 */
		
		Element namElement = doc.getRootElement()
		.element("contact")
		.element("name");
		
		namElement.setText("�����");
		
		
		//�������޸ĺ��Document����л����xml�ĵ���
		FileOutputStream out = new FileOutputStream("e:/aa.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doc);
		writer.close();
	}
	
	/**
	 * ɾ������ǩ������
	 * @throws Exception
	 */
	
	@Test
	public void test3Name() throws Exception {
		// һ����ȡ�򴴽�һ��Document����
		Document doc = new SAXReader().read(new File("./day7/contact.xml"));
		
		
		/**
		 * 1.ɾ����ǩ            �õ���ǩ����   -> ɾ����ǩ����
		 */
		//1.1�õ���ǩ����
		Element ageElement = doc.getRootElement().element("contact")
							.element("age");
		
		//1.2ɾ����ǩ����
//		ageElement.detach();
		ageElement.getParent().remove(ageElement);
		
		
		/**
		 * 2.ɾ������    �õ����Զ��� -> ɾ������
		 */
		//2.1�õ����Զ���
		//�õ��ڶ���contact��ǩ
		Element contactElement = (Element) doc.getRootElement()
		.elements("contact").get(1);
		
		//2.2ɾ�����Զ���
		Attribute idaAttribute = contactElement.attribute("id");
		
		//2.3ɾ������
		idaAttribute.detach();
//		idaAttribute.getParent().remove(idaAttribute);
		
		//�������޸ĺ��Document����л����xml�ĵ���
		FileOutputStream out = new FileOutputStream("e:/aa.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doc);
		writer.close();
	}
}
