package javaxmlcert;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;

import org.junit.Test;


public class KeyStoreTest {

	/**
	 * verify thet the p12 file has been well created 
	 * */
	@Test	
	public void testP12File() throws Exception {

		KeyStore myStore = KeyStore.getInstance("PKCS12");
		// InputStream  stream = getClass().getClassLoader().getResourceAsStream("jordi.p12");
		myStore.load(getClass().getClassLoader().getResourceAsStream("jordi.p12"), "jordipwd".toCharArray());
		// while  ( myStore.aliases().hasMoreElements()) {
		// 	System.out.println(myStore.aliases().nextElement());
		// }
		System.out.println(myStore.size());
		assertTrue(myStore.size() > 0);
		// assertNotNull(myStore);
		
	 	Key clave = myStore.getKey("jordialias", "jordipwd".toCharArray());
		System.out.println(clave.getFormat());
		assertNotNull(clave);
	   	
	}

	@Test
	public void testGenericKeyStore(){
		SignatureUtil signatureUtil = new SignatureUtil();
		PrivateKey pk = signatureUtil.getPrivateKey("jordi.p12","jordipwd" ,"jordialias" );
		assertNotNull(pk);
	}
	public KeyStoreTest() {
	}
}
