package javaxmlcert;

import org.w3c.dom.Document;
import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;

public class XmlUtil {

	public static Document getXmlFromResoureces(String xmlresource) {
		Document doc = null;
		try {

			File inputFile = new File(XmlUtil.class.getClassLoader().getResource(xmlresource).getFile());
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(inputFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doc;
	}

	public static void writeDom(Document dom) {
		String content = null;
		try {
			DOMSource source = new DOMSource(dom);
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transf = transformerFactory.newTransformer();

			transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transf.setOutputProperty(OutputKeys.INDENT, "yes");
			transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			StreamResult console = new StreamResult(System.out);

			transf.transform(source, console);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		

	}

}
