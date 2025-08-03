import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;

public class FileWriterAndScanner {
    public static void main(String[] args) {
        try {
            File direc = new File ("File_Folder");
            direc.mkdir();
            System.out.println("=== FileWriter will create a new file if not already exist ===");
            FileWriter fileWriter = new FileWriter("File_Folder/source.txt"); 

            Scanner input = new Scanner(System.in);
            System.out.print("Text: ");
            String textInput = "";
            while(input.hasNextLine()) {
                String newText = input.nextLine();
                textInput = textInput + newText + "\n";
            }
            fileWriter.write(textInput);
            fileWriter.close();

            System.out.println("\n\n=== Appending same content to a file ===");
            FileWriter fileWriter1 = new FileWriter("File_Folder/source.txt", true);
            fileWriter1.write(textInput);
            fileWriter1.close();

            System.out.println("\nSuccessfully wrote to the file.\n");

            File fileObj = new File("File_Folder/source.txt");
            Scanner sc = new Scanner(fileObj);
            while(sc.hasNextLine()) {
                String text = sc.nextLine();
                System.out.println(text);
            }
            sc.close();

            System.out.println("\n=== Scanner with String ===");
            Scanner sc1 = new Scanner("""
                This is line 1
                This is line 2
                This is line 3
                """);
            while(sc1.hasNextLine()) {
                String text = sc1.nextLine();
                System.out.println(text);
            }
            sc1.close();
        }
        catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }
}