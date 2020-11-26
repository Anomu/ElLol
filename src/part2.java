import javax.crypto.SecretKey;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class part2 {

    public static void exercici1() throws IOException {
        File f = new File("c:/Users/Anomu/Desktop/clausA4.txt");

        FileReader r = new FileReader(f);
        BufferedReader buff = new BufferedReader(r);

        Path p = Paths.get("c:/Users/Anomu/Desktop/textamagat");
        byte[] textoCompiladoBytes = Files.readAllBytes(p);


        String sClave = buff.readLine();

        while(sClave!=null) {
            SecretKey clave = Xifrar.passwordKeyGeneration(sClave, 128);

            try {
                byte[] textoDescompilaoBytes = Xifrar.decryptData(clave, textoCompiladoBytes);
                String textoDescompilao = new String(textoDescompilaoBytes, "UTF8");
                System.out.println(textoDescompilao);
            } catch (Exception e) { }

            sClave = buff.readLine();
        }
    }
}
