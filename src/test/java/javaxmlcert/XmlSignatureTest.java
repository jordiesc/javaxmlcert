package javaxmlcert;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class XmlSignatureTest {

	@Test
	public void testXmlDom() {
		assertNotNull(XmlUtil.getXmlFromResoureces("school.xml"));	
		
	}

	public XmlSignatureTest() {
	}

}
