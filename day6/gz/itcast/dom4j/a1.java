package gz.itcast.dom4j;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

/*

*/
public class a1 {

	public static void main(String[] args) {
		
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File("./day6/contact.xml"));
			
			System.out.println(doc);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
