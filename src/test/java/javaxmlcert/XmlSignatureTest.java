package javaxmlcert;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

class XmlSignatureTest {

	@Test
	void testXmlDom() {
		assertNotNull(XmlUtil.getXmlFromResoureces("school.xml"));	
		
	}

}
