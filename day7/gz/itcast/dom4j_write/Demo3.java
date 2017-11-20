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
 * 修改xml内容
 * 增加：标签、属性
 * 修改：属性值、文本
 * 删除：标签、属性
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
		// 一、读取或创建一个Document对象
		//创建文档
		Document doc = DocumentHelper.createDocument();
		
		//2.增加标签
		Element rootelElement = doc.addElement("contactList");
		Element contractelElement = rootelElement.addElement("contact");
		contractelElement.addElement("name");
		
		//3.添加属性
		contractelElement.addAttribute("id", "001");
		contractelElement.addAttribute("name", "lwz");
		//二、修改Document对象
		
		
		
		
		
		
		//三、把修改后的Document对象谢楚道xml文档中
		FileOutputStream out = new FileOutputStream("e:/aa.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doc);
		writer.close();
	}
	
	@Test
	public void test2Name() throws Exception {
		// 一、读取或创建一个Document对象
		Document doc = new SAXReader().read(new File("./day7/contact.xml"));
		
		
		//二、修改Document对象
		
		// 方案一：修改属性值    
		//得到标签对象 ->得到属性对象 -> 修改属性值
		//1.1得到标签对象
		Element contactelement = doc.getRootElement().element("contact");
		
		//1.2得到属性对象
		Attribute idaAttribute = contactelement.attribute("id");
		
		//1.3修改属性值
		idaAttribute.setValue("aaaaa");
		
		//方案二：修改属性值
		//1.1得到标签对象
		Element contactElement2 = doc.getRootElement().element("contact");
		
		//1.2通过增加同名属性的方法,修改属性值
		contactElement2.addAttribute("id","0004");
		
		
		/**
		 * 修改文本     得到标签对象 -> 修改文本
		 */
		
		Element namElement = doc.getRootElement()
		.element("contact")
		.element("name");
		
		namElement.setText("刘书豪");
		
		
		//三、把修改后的Document对象谢楚道xml文档中
		FileOutputStream out = new FileOutputStream("e:/aa.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doc);
		writer.close();
	}
	
	/**
	 * 删除：标签，属性
	 * @throws Exception
	 */
	
	@Test
	public void test3Name() throws Exception {
		// 一、读取或创建一个Document对象
		Document doc = new SAXReader().read(new File("./day7/contact.xml"));
		
		
		/**
		 * 1.删除标签            得到标签对象   -> 删除标签对象
		 */
		//1.1得到标签对象
		Element ageElement = doc.getRootElement().element("contact")
							.element("age");
		
		//1.2删除标签对象
//		ageElement.detach();
		ageElement.getParent().remove(ageElement);
		
		
		/**
		 * 2.删除属性    得到属性对象 -> 删除属性
		 */
		//2.1得到属性对象
		//得到第二个contact标签
		Element contactElement = (Element) doc.getRootElement()
		.elements("contact").get(1);
		
		//2.2删除属性对象
		Attribute idaAttribute = contactElement.attribute("id");
		
		//2.3删除属性
		idaAttribute.detach();
//		idaAttribute.getParent().remove(idaAttribute);
		
		//三、把修改后的Document对象谢楚道xml文档中
		FileOutputStream out = new FileOutputStream("e:/aa.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doc);
		writer.close();
	}
}
