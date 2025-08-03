import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class Base64Ex {
    public static void main(String[] args) {
        String originalString = "Hello Java Base64!";

        System.out.println("=== Basic Encoding ===");
        System.out.println("Charset: A–Z, a–z, 0–9, +, / and = (padding to make it divisible by 24 bits (4 base64 chars))");
        String encodedString = Base64.getEncoder().encodeToString(originalString.getBytes(StandardCharsets.UTF_16));
        System.out.println("Encoded String: " + encodedString);
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes, StandardCharsets.UTF_16);
        System.out.println("Decoded String: " + decodedString);

        System.out.println("\n=== MIME Encoding ==="); // Multipurpose Internet Mail Extensions
        System.out.println("Charset: A–Z, a–z, 0–9, +, / and = (padding to make it divisible by 24 bits (4 base64 chars))");
        String mimeEncodedString = Base64.getMimeEncoder().encodeToString(originalString.getBytes());
        System.out.println("Encoded String: " + mimeEncodedString);
        byte[] mimeDecodedBytes = Base64.getMimeDecoder().decode(mimeEncodedString);
        String mimeDecodedString = new String(mimeDecodedBytes);
        System.out.println("Decoded String: " + mimeDecodedString);

        System.out.println("\n=== URL Encoding ==="); // Uniform Resource Locator
        System.out.println("Charset: A–Z, a–z, 0–9, -, _ and = (padding to make it divisible by 24 bits (4 base64 chars))");
        String urlEncodedString = Base64.getUrlEncoder().encodeToString(originalString.getBytes());
        System.out.println("Encoded String: " + urlEncodedString);
        byte[] urlDecodedBytes = Base64.getUrlDecoder().decode(urlEncodedString);
        String urlDecodedString = new String(urlDecodedBytes);
        System.out.println("Decoded String: " + urlDecodedString);
    }
}