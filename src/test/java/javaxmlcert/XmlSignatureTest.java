package javaxmlcert;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.xml.crypto.dsig.keyinfo.KeyInfo;

import org.junit.Test;
import org.w3c.dom.Document;

public class XmlSignatureTest {

	@Test
	public void testXmlDom() {
		Document dom = XmlUtil.getXmlFromResoureces("school.xml");
		XmlUtil.writeDom(dom);
		assertNotNull(dom);
	}

	@Test
	public void testKeyXmlInf() {
		SignatureUtil util = new SignatureUtil();
		KeyInfo info = util.getXmlKeyInfo("jordi.p12","jordipwd","jordialias");
		assertNotNull(info);
	}

	@Test
	public void createSignature(){
		SignatureUtil util = new SignatureUtil();
		util.createSignature();
		assertTrue("done", true);
	}

	public XmlSignatureTest() {
	}

}
