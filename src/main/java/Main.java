import bootstrap.Application;
import org.apache.commons.codec.digest.HmacUtils;

import static org.apache.commons.codec.digest.HmacAlgorithms.HMAC_SHA_224;

public class Main {
    private static final String secret = "secret";
    public static void main(String[] args) {
   //     Application.runApplication();

        String hashedPassword = new HmacUtils(HMAC_SHA_224, secret.getBytes()).hmacHex("4321j");
        String hashedPassword1 = new HmacUtils(HMAC_SHA_224, secret.getBytes()).hmacHex("qwert5");
        System.out.println(hashedPassword);
        System.out.println(hashedPassword1);
    }
}