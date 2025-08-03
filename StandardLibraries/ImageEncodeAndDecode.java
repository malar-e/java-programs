import java.io.*;
import java.util.Base64;

public class ImageEncodeAndDecode {
    public static void main(String[] args) {
        try {
            File image = new File("File_Folder/image.png");
            FileInputStream fis = new FileInputStream(image);
            byte[] imageBytes = new byte[(int) image.length()];
            fis.read(imageBytes);
            fis.close();

            String encodedString = Base64.getEncoder().encodeToString(imageBytes);
            System.out.println("Encoded string: " + encodedString.substring(0,100));

            byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
            FileOutputStream newImage = new FileOutputStream("File_Folder/output.png");
            newImage.write(decodedBytes);
            newImage.close();

            System.out.println("New image created successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}