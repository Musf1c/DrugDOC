import bootstrap.Application;
import org.apache.commons.codec.digest.HmacUtils;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.apache.commons.codec.digest.HmacAlgorithms.HMAC_SHA_224;

public class Main {
    private static final String secret = "secret";
    public static void main(String[] args) {
       //Application.runApplication();
        Calendar calendar = new GregorianCalendar(2024, 11, 8);
        System.out.println(LocalDate.now());

    }
}