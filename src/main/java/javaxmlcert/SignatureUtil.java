package javaxmlcert;

import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.util.Collections;

import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;

import org.w3c.dom.Document;

class SignatureUtil {

	public void createSignature() {
		Document doc = XmlUtil.getXmlFromResoureces("school.xml");
		PrivateKey privateKey = getPrivateKey("jordi.p12", "jordipwd", "jordialias");

		XMLSignatureFactory xmlSigFactory = XMLSignatureFactory.getInstance("DOM");
		DOMSignContext domSignCtx = new DOMSignContext(privateKey, doc.getDocumentElement());

		//////////////// 77
		//////////////////////
		Reference ref = null;
		SignedInfo signedInfo = null;
		try {
			ref = xmlSigFactory.newReference("", xmlSigFactory.newDigestMethod(DigestMethod.SHA1, null),
					Collections.singletonList(
							xmlSigFactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null)),
					null, null);
			signedInfo = xmlSigFactory.newSignedInfo(
					xmlSigFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE,
							(C14NMethodParameterSpec) null),
					xmlSigFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(ref));
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		} catch (InvalidAlgorithmParameterException ex) {
			ex.printStackTrace();
		}
		// Pass the Public Key File Path
		KeyInfo keyInfo = getXmlKeyInfo("jordi.p12","jordipwd","jordialias");
		// Create a new XML Signature
		
		//XMLSignature xmlSignature = xmlSigFactory.newXMLSignature(signedInfo, );

		////////////////////// 7
		//////////////////// 7
		//////////////////////// 7

	}

	public PrivateKey getPrivateKey(String filep12, String pwd, String alias) {
		Key clave = null;
		try {
			KeyStore myStore = KeyStore.getInstance("PKCS12");
			myStore.load(getClass().getClassLoader().getResourceAsStream(filep12), pwd.toCharArray());
			clave = myStore.getKey(alias, pwd.toCharArray());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (PrivateKey) clave;
	}

	/**
	 * class represntation KeyInfo wich is a xml representation of the certificate public
	 * @param filep12
	 * @param pwd
	 * @param alias
	 * @return
	 */
	public KeyInfo getXmlKeyInfo(String filep12, String pwd, String alias) {

		KeyInfo keyInfo = null;
		KeyValue keyValue = null;
		// KeyInfoFactory.getInstance().newKeyValue(key.)
		try {
			KeyStore myStore = KeyStore.getInstance("PKCS12");
			myStore.load(getClass().getClassLoader().getResourceAsStream(filep12), pwd.toCharArray());
			Certificate cert = myStore.getCertificate(alias);
			KeyInfoFactory kif = KeyInfoFactory.getInstance("DOM");

			keyValue = kif.newKeyValue(cert.getPublicKey());
			keyInfo = kif.newKeyInfo(Collections.singletonList(keyValue));

		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return keyInfo;
	}
}
