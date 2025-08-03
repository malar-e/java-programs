import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.util.Scanner;

public class FileInputAndOutputStream {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("File_Folder/source.txt");
            FileOutputStream fos = new FileOutputStream("File_Folder/destination.txt")){
            int i;
            File fileObj = new File("File_Folder/example.txt");
            fileObj.createNewFile();
            FileOutputStream exampleFos = new FileOutputStream(fileObj);
            String str = """
                This is line 1
                This is line 2
                This is line 3
                """;
            exampleFos.write(str.getBytes());
            exampleFos.close();

            Scanner input = new Scanner(System.in);
            System.out.print("Text: ");
            String textInput = "";
            while(input.hasNextLine()) {
                String newText = input.nextLine();
                textInput = textInput + newText + "\n";
            }
            FileOutputStream exampleFosAppend = new FileOutputStream(fileObj, true);
            exampleFosAppend.write(textInput.getBytes());
            System.out.print("\n\n");

            FileInputStream exampleFis = new FileInputStream(fileObj);
            while((i=exampleFis.read())!=-1) { // -1 means EOF
                System.out.print((char) i);
            }
            exampleFis.close();
            System.out.println();

            while((i=fis.read())!=-1) { // -1 means EOF
                System.out.print((char) i);
                fos.write(i);
            }
        }
        catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}