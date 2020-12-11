import javax.crypto.SecretKey;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.KeyPair;
import java.security.KeyStore;
import java.util.Scanner;

public class A5 {
    public static void exercici1_1_i() throws UnsupportedEncodingException {

        String txt = "El lol es droga";
        byte[] txtBytes = txt.getBytes();

        KeyPair key = Xifrar.randomGenerate(1024);

        byte[] txtCifradoBytes = Xifrar.encryptData(txtBytes,key.getPublic());
        String txtCifrado = new String(txtCifradoBytes,"UTF-8");
        System.out.println(txtCifrado);

        byte[] txtDescifradoBytes =  Xifrar.dencryptData(txtCifradoBytes, key.getPrivate());
        String txtDescifrado = new String(txtDescifradoBytes, "UTF-8");
        System.out.println(txtDescifrado);


    }

    public static void exercici1_1_ii() throws UnsupportedEncodingException {

        Scanner sc = new Scanner(System.in);
        String txt = sc.nextLine();
        byte[] txtBytes = txt.getBytes();

        KeyPair key = Xifrar.randomGenerate(1024);

        byte[] txtCifradoBytes = Xifrar.encryptData(txtBytes,key.getPublic());
        String txtCifrado = new String(txtCifradoBytes,"UTF-8");
        System.out.println(txtCifrado);

        byte[] txtDescifradoBytes =  Xifrar.dencryptData(txtCifradoBytes, key.getPrivate());
        String txtDescifrado = new String(txtDescifradoBytes, "UTF-8");
        System.out.println(txtDescifrado);


    }

    public static void exercici1_1_iii(){

        KeyPair key = Xifrar.randomGenerate(1024);
        System.out.println(key.getPrivate());
        System.out.println(key.getPrivate().getAlgorithm());
        System.out.println(key.getPrivate().getEncoded());
        System.out.println(key.getPublic().getAlgorithm());
        System.out.println(key.getPublic().getEncoded());

    }

    public static void  exercici2_i() throws Exception {

        KeyStore keyStore = Xifrar.loadKeyStore("C:\\Users\\Anomu\\Desktop\\keystore.ks","contra");

        System.out.println(keyStore.getType());
        System.out.println(keyStore.size());
        System.out.println(keyStore.aliases().asIterator().next());
        System.out.println(keyStore.getCertificate(keyStore.aliases().nextElement()));
        System.out.println(keyStore.getKey("usuari","usuari".toCharArray()).getAlgorithm());
    }

    public static void exercici2_ii() throws Exception {

        KeyStore keyStore = Xifrar.loadKeyStore("C:\\Users\\Anomu\\Desktop\\keystore.ks","contra");

        SecretKey key = Xifrar.keygenKeyGeneration(256);

        KeyStore.ProtectionParameter protectionParameter = new KeyStore.PasswordProtection("contra".toCharArray());
        KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(key);

        keyStore.setEntry("keyex",secretKeyEntry ,protectionParameter );
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Anomu\\Desktop\\keystore.ks");
        keyStore.store(fileOutputStream, "contra".toCharArray());
        fileOutputStream.close();

    }

    public static void exercici3() throws Exception {

        System.out.println(Xifrar.getPublicKey("C:\\Users\\Anomu\\Desktop\\lol.cer"));

    }

}
