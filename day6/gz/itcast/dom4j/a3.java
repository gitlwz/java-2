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
		//��ȡ��xml���ĵ�
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./day6/contact.xml"));	
		Element rooteleElement = doc.getRootElement();
		
		StringBuffer sb = new StringBuffer();
		getChildElement(rooteleElement,sb);
		System.out.println(sb.toString());
	}
	
	/**
	 * ��ȡ��ǰ��ǩ���ֱ�ǩ
	 */
	private static void getChildElement(Element elem,StringBuffer sb) {
//		System.out.println(elem.getName());
		
		//��ʼ��ǩ
		sb.append("<" + elem.getName());
		
		//�õ���ǩ�������б�
		List<Attribute> attributes = elem.attributes();
		if(attributes != null){
			for(Attribute attribute : attributes){
//				System.out.println(attribute.getName() + "=" + attribute.getValue());
				sb.append(" "+ attribute.getName() + "= \""+ attribute.getValue() + "\"");
			}
		}
		sb.append(">");
		
		//�õ��ı�
		String contentString = elem.getText();
		sb.append(elem.getText());
//		System.out.println(contentString);
		
		
		List<Element> list = elem.elements();	
		for(Element element : list){
			//�ݹ�
			getChildElement(element,sb);
		}
		
		//������ǩ
		sb.append("</" + elem.getName() + ">");
	}
}
