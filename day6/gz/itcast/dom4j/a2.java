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
		
		
		//得到当前节点下的所有子节点对象（不包括孙以下的节点）
		
		Iterator<Node> iterator = doc.nodeIterator();
		
		while (iterator.hasNext()) {
			Node node = (Node) iterator.next();
			String name = node.getName(); //获取节点名称
			System.out.println(name);
			
			//继续获取出其下面的子节点
			//只有标签节点才有子节点
			
			//判断当前节点是否是标签节点
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
		
		
		//得到跟标签
		
		Element rootElement = doc.getRootElement();
		getChildNode(rootElement);
	}
	
	/**
	 * 获取传入的标签下的所有子节点
	 * @param elem
	 */
	private static void getChildNode(Element elem) {
		System.out.println(elem.getName());
		
		
		//得到子节点
		Iterator<Node> it = elem.nodeIterator();
		while (it.hasNext()) {
			Node node = (Node) it.next();
			
			//判断是否是标签节点
			if(node instanceof Element){
				Element el = (Element)node;
				//递归
				getChildNode(el);
			}
		}
	}
	
	
	public static void test3() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./day6/contact.xml"));
		
		
		//2.得到跟标签
		Element rootElem = doc.getRootElement();
		//得到标签名称
		
		String name = rootElem.getName();
//		System.out.println(name);
		
		//3.得到当前标签下制定名称的第一个字标签
		Element contactElem = rootElem.element("contact");
//		System.out.println(contactElem.getName());
		
		
		//4得到当前标签下指定名称的所有字标签
		Iterator<Element> it = rootElem.elementIterator("contact");
		
		while (it.hasNext()) {
			Element element = (Element) it.next();
			System.out.println(element.getName());
		}
		
		//5.得到当前标签下的所有字标签
		List<Element> list =  rootElem.elements();
		System.out.println("-----5---------------");
		
		for(Element e : list){
			System.out.println(e.getName());
		}
		
		//获取更深层次的标签（方法只能一层层的获取）
		
		
	}
	/**
	 * 获取属性
	 * @throws DocumentException
	 */
	
	public static void test4() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./day6/contact.xml"));
		
		//获取属性：（先获得属性所在的标签对象，然后才能获得属性）
		Element contactElem = doc.getRootElement().element("contact");
		
		//2.得到属性
		//2.1 得到指定名称的属性值
		String idValue = contactElem.attributeValue("id");
		System.out.println(idValue);
		
		System.out.println("--------2-------");
		
		//2.2得到指定属性名称的属性对象
		Attribute idAttr = contactElem.attribute("id");
		System.out.println(idAttr.getName() + "=" + idAttr.getValue());
		
		
		System.out.println("-----------2.2------------");
		List<Attribute> list = contactElem.attributes();
		
		for(Attribute attribute : list){
			System.out.println(attribute.getName() +"="+attribute.getValue());
		}
		
		
	}
	
	/**
	 * 获取文本
	 * @throws DocumentException 
	 */
	public static void test5() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./day6/contact.xml"));
		
		//先获得标签，再获取标签上的文本
		Element namElement = doc.getRootElement().element("contact").element("name");
		
		//1得到文本
		String text = namElement.getText();
		System.out.println(text);
		
		//2. 得到指定字标签名的文本内容
		String text2 = 
				doc.getRootElement().element("contact").elementText("name");
		
		
		System.out.println(text2);
		
//	    String text3 =
//	    		doc.getRootElement().element("contact").getText();
//	    System.out.println(text3);
		
	}
}
