package gz.itcast.dom4j;

import java.util.List;
import java.io.File;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/*

*/
public class a2 {

	public static void main(String[] args) throws DocumentException {
		
		
		
//		test2();
//		test3();
//		test4();
		test5();
	}
	public static void test1() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./day6/contact.xml"));
		
		
		//�õ���ǰ�ڵ��µ������ӽڵ���󣨲����������µĽڵ㣩
		
		Iterator<Node> iterator = doc.nodeIterator();
		
		while (iterator.hasNext()) {
			Node node = (Node) iterator.next();
			String name = node.getName(); //��ȡ�ڵ�����
			System.out.println(name);
			
			//������ȡ����������ӽڵ�
			//ֻ�б�ǩ�ڵ�����ӽڵ�
			
			//�жϵ�ǰ�ڵ��Ƿ��Ǳ�ǩ�ڵ�
			if(node instanceof Element){
				Element ele = (Element)node;
				Iterator<Node> it2 = ele.nodeIterator();
				while (it2.hasNext()) {
					Node node2 = (Node) it2.next();
					
					System.out.println(node2.getName());
					
				}
			}
			
		}
	}
	
	@Test
	public static void test2() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./day6/contact.xml"));
		
		
		//�õ�����ǩ
		
		Element rootElement = doc.getRootElement();
		getChildNode(rootElement);
	}
	
	/**
	 * ��ȡ����ı�ǩ�µ������ӽڵ�
	 * @param elem
	 */
	private static void getChildNode(Element elem) {
		System.out.println(elem.getName());
		
		
		//�õ��ӽڵ�
		Iterator<Node> it = elem.nodeIterator();
		while (it.hasNext()) {
			Node node = (Node) it.next();
			
			//�ж��Ƿ��Ǳ�ǩ�ڵ�
			if(node instanceof Element){
				Element el = (Element)node;
				//�ݹ�
				getChildNode(el);
			}
		}
	}
	
	
	public static void test3() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./day6/contact.xml"));
		
		
		//2.�õ�����ǩ
		Element rootElem = doc.getRootElement();
		//�õ���ǩ����
		
		String name = rootElem.getName();
//		System.out.println(name);
		
		//3.�õ���ǰ��ǩ���ƶ����Ƶĵ�һ���ֱ�ǩ
		Element contactElem = rootElem.element("contact");
//		System.out.println(contactElem.getName());
		
		
		//4�õ���ǰ��ǩ��ָ�����Ƶ������ֱ�ǩ
		Iterator<Element> it = rootElem.elementIterator("contact");
		
		while (it.hasNext()) {
			Element element = (Element) it.next();
			System.out.println(element.getName());
		}
		
		//5.�õ���ǰ��ǩ�µ������ֱ�ǩ
		List<Element> list =  rootElem.elements();
		System.out.println("-----5---------------");
		
		for(Element e : list){
			System.out.println(e.getName());
		}
		
		//��ȡ�����εı�ǩ������ֻ��һ���Ļ�ȡ��
		
		
	}
	/**
	 * ��ȡ����
	 * @throws DocumentException
	 */
	
	public static void test4() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./day6/contact.xml"));
		
		//��ȡ���ԣ����Ȼ���������ڵı�ǩ����Ȼ����ܻ�����ԣ�
		Element contactElem = doc.getRootElement().element("contact");
		
		//2.�õ�����
		//2.1 �õ�ָ�����Ƶ�����ֵ
		String idValue = contactElem.attributeValue("id");
		System.out.println(idValue);
		
		System.out.println("--------2-------");
		
		//2.2�õ�ָ���������Ƶ����Զ���
		Attribute idAttr = contactElem.attribute("id");
		System.out.println(idAttr.getName() + "=" + idAttr.getValue());
		
		
		System.out.println("-----------2.2------------");
		List<Attribute> list = contactElem.attributes();
		
		for(Attribute attribute : list){
			System.out.println(attribute.getName() +"="+attribute.getValue());
		}
		
		
	}
	
	/**
	 * ��ȡ�ı�
	 * @throws DocumentException 
	 */
	public static void test5() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./day6/contact.xml"));
		
		//�Ȼ�ñ�ǩ���ٻ�ȡ��ǩ�ϵ��ı�
		Element namElement = doc.getRootElement().element("contact").element("name");
		
		//1�õ��ı�
		String text = namElement.getText();
		System.out.println(text);
		
		//2. �õ�ָ���ֱ�ǩ�����ı�����
		String text2 = 
				doc.getRootElement().element("contact").elementText("name");
		
		
		System.out.println(text2);
		
//	    String text3 =
//	    		doc.getRootElement().element("contact").getText();
//	    System.out.println(text3);
		
	}
}
