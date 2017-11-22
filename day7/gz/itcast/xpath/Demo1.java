package gz.itcast.xpath;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		Document doc = new SAXReader().read(new File("./day7/personList.html"));
		System.out.println(doc);
		
		
		//读取title标签
		Element titleElem = (Element)doc.selectSingleNode("//title");
		String title = titleElem.getText();
		System.out.println(title);
		
		/**
		 * 联系：读取联系人的所有信息
		 * 按照以下格式输出：
		 * 	编号:001 姓名:张三
		 */
		
	}	

}
