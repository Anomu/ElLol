import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class algo {

    public  static void ejercicio5() throws UnsupportedEncodingException {

        SecretKey key = Xifrar.keygenKeyGeneration(256);


        String texto = "Encriptar cosas es divertido.";

        byte[] textoBytes = texto.getBytes();
        System.out.println(textoBytes);

        byte[] textoCompliaoBytes = Xifrar.encryptData(key, textoBytes);
        String textoCompilao = new String(textoCompliaoBytes, "UTF8");
        System.out.println(textoCompilao);

        byte[] textoDescompilaoBytes = Xifrar.decryptData(key, textoCompliaoBytes);
        String textoDescompilao = new String(textoDescompilaoBytes, "UTF8");
        System.out.println(textoDescompilao);

    }

    public  static void ejercicio6() throws UnsupportedEncodingException {
        Scanner scanner = new Scanner(System.in);

        SecretKey key = Xifrar.passwordKeyGeneration("dalvarez", 256);

        String texto = "Encriptar cosas es divertido, pero ahora con contraseña.";

        byte[] textoBytes = texto.getBytes();
        System.out.println(textoBytes);

        byte[] textoCompliaoBytes = Xifrar.encryptData(key, textoBytes);
        String textoCompilao = new String(textoCompliaoBytes, "UTF8");
        System.out.println(textoCompilao);

        System.out.println("Password: ");
        String clave = scanner.nextLine();
        SecretKey kClave = Xifrar.passwordKeyGeneration(clave, 256);

        try{
        byte[] textoDescompilaoBytes = Xifrar.decryptData(kClave, textoCompliaoBytes);
        String textoDescompilao = new String(textoDescompilaoBytes, "UTF8");
        System.out.println(textoDescompilao);
        }catch(Exception e){ }
    }

    public static void ejercicio7(){

        SecretKey laclavedelocos = Xifrar.passwordKeyGeneration("laclavedelocos", 128);

        System.out.println("Algoritmo de la clave de locos: "+laclavedelocos.getAlgorithm());

    }

}
