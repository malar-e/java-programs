import java.io.*;
import java.util.Base64;

public class TextFileEncodeAndDecode {
    public static void main(String[] args) {
        try {
            File fileObj = new File("File_Folder/example.txt");
            FileInputStream fis = new FileInputStream(fileObj);
            byte[] textBytes = new byte[(int) fileObj.length()];
            fis.read(textBytes);
            fis.close();

            String encodedString = Base64.getEncoder().encodeToString(textBytes);
            System.out.println("Encoded string: " + encodedString);

            byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
            System.out.println("\nDecoded string: " + new String(decodedBytes));

            FileOutputStream fos = new FileOutputStream("File_Folder/outputText.txt");
            fos.write(decodedBytes);
            fos.close();

            System.out.println("New Text file created successfully.");
        }
        catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        

    }
}