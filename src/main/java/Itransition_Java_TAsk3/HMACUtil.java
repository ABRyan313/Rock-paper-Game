package Itransition_Java_TAsk3;



import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class HMACUtil {
    public static String generateKey() {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[32]; // 256-bit key
        random.nextBytes(key);
        return Base64.getEncoder().encodeToString(key);
    }

    public static String calculateHMAC(String data, String key) {
        try {
            byte[] keyBytes = Base64.getDecoder().decode(key);
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "HmacSHA3-256");
            Mac mac = Mac.getInstance("HmacSHA3-256");
            mac.init(secretKeySpec);
            byte[] hmacBytes = mac.doFinal(data.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hmacBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to calculate HMAC", e);
        }
    }
}
