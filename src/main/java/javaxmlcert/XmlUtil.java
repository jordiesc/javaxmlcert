package javaxmlcert;

import org.w3c.dom.Document;
import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

public class XmlUtil {
		
	public static Document getXmlFromResoureces(String xmlresource) {
		Document doc = null;
		try {

			File inputFile =  new File(XmlUtil.class.getClassLoader().getResource(xmlresource).getFile());
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(inputFile);
		} catch (Exception e){
	  		e.printStackTrace();
	  	}
	  return doc;	
	}

}
