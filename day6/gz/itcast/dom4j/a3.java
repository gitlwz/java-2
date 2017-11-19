package gz.itcast.dom4j;

import java.io.File;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class a3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		testname();
	}
	
	
	
	public static void testname() throws Exception {
		//读取到xml的文档
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./day6/contact.xml"));	
		Element rooteleElement = doc.getRootElement();
		
		StringBuffer sb = new StringBuffer();
		getChildElement(rooteleElement,sb);
		System.out.println(sb.toString());
	}
	
	/**
	 * 获取当前标签的字标签
	 */
	private static void getChildElement(Element elem,StringBuffer sb) {
//		System.out.println(elem.getName());
		
		//开始标签
		sb.append("<" + elem.getName());
		
		//得到标签的属性列表
		List<Attribute> attributes = elem.attributes();
		if(attributes != null){
			for(Attribute attribute : attributes){
//				System.out.println(attribute.getName() + "=" + attribute.getValue());
				sb.append(" "+ attribute.getName() + "= \""+ attribute.getValue() + "\"");
			}
		}
		sb.append(">");
		
		//得到文本
		String contentString = elem.getText();
		sb.append(elem.getText());
//		System.out.println(contentString);
		
		
		List<Element> list = elem.elements();	
		for(Element element : list){
			//递归
			getChildElement(element,sb);
		}
		
		//结束标签
		sb.append("</" + elem.getName() + ">");
	}
}
