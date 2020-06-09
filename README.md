# javaxmlcert
test with xml cert

good tutorial here https://www.javacodegeeks.com/2013/10/xml-security-with-digital-signature-in-java.html

# create pem cert

All the files are in test/resources

the below steps create a key par and export the public key as a cert format

`openssl req -new -newkey rsa:4096 -nodes -keyout jordi.key -out jordi.csr`
`openssl x509 -req -sha256 -days 365 -in jordi.csr -signkey jordi.key -out jordi.pem`

create a keysotre p12 no password for export

`openssl pkcs12 -export -out jordi.p12 -in jordi.pem -inkey jordi.pem`

inspect the content with java keytool

`keytool -list -v -keystore jordi.p12`

## tests included

* test to read pem files
