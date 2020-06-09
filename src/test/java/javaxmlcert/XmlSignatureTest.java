package javaxmlcert;

import static org.junit.Assert.assertNotNull;

import javax.xml.crypto.dsig.keyinfo.KeyInfo;

import org.junit.Test;

public class XmlSignatureTest {

	@Test
	public void testXmlDom() {
		assertNotNull(XmlUtil.getXmlFromResoureces("school.xml"));	
		
	}

	@Test
	public void testKeyXmlInf() {
		SignatureUtil util = new SignatureUtil();
		KeyInfo info = util.getXmlKeyInfo("jordi.p12","jordipwd","jordialias");
		assertNotNull(info);
	}

	public XmlSignatureTest() {
	}

}
