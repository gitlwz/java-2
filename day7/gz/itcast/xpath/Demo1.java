package gz.itcast.xpath;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		Document doc = new SAXReader().read(new File("./day7/personList.html"));
		System.out.println(doc);
		
		
		//��ȡtitle��ǩ
		Element titleElem = (Element)doc.selectSingleNode("//title");
		String title = titleElem.getText();
		System.out.println(title);
		
		/**
		 * ��ϵ����ȡ��ϵ�˵�������Ϣ
		 * �������¸�ʽ�����
		 * 	���:001 ����:����
		 */
		
	}	

}
