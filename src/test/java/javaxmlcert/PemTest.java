package javaxmlcert;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.InputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import org.junit.Before;
import org.junit.Test;

public class PemTest {

	InputStream inputstream;
	@Before
	public void loadPemFile() {
		inputstream = getClass().getClassLoader().getResourceAsStream("jordi.pem");
	}


	@Test
	public void testX509() throws Exception{
			
		X509Certificate certificate = (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(inputstream);
		assertNotNull(certificate);
		certificate.checkValidity();

		String cn = certificate.getSubjectDN().getName();
		
		assertTrue(cn.contains("CN=jordi"));
	}

	public PemTest() {
	}
}


