package javaxmlcert;

import static org.junit.Assert.assertNotNull;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyStore;

import org.apache.commons.io.IOUtils;
import org.junit.Test;


class KeyStoreTest {

	@Test	
	void testP12File() throws Exception {
		System.out.println("JORDIIII");
		KeyStore myStore = KeyStore.getInstance("PKCS12");
		// String ficherito1 = IOUtils.toString(stream,StandardCharsets.UTF_8);
		String ficherito = IOUtils.resourceToString("school.xml",StandardCharsets.UTF_8);
		System.out.println("sacamos el fichero");
		System.out.println(ficherito);
		// InputStream  stream = getClass().getResourceAsStream("jordi.p12");
		//System.out.println(ficherito1);
		myStore.load(this.getClass().getResourceAsStream("jordi.p12"), "jordipwd".toCharArray());
		while  ( myStore.aliases().hasMoreElements()) {
			System.out.println(myStore.aliases().nextElement());
		}
		System.out.println(myStore.size());
		// assertNotNull(myStore);

	 	Key clave = myStore.getKey("1", "jordipwd".toCharArray());
		assertNotNull(clave);
	   	
	}
}
