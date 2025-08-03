import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class FileHandling {
    public static void main (String[] args) {
        FileWriter fileWriter = null;
        Scanner sc = null;
        try {
            File dirObj = new File ("/Users/malarvizhi.e/Documents/java-programs/FileHandling/Files");
            boolean isDirCreated = dirObj.mkdir();
            if (isDirCreated) {
                System.out.println("Directory created: " + dirObj.getName());
            } else {
                System.out.println("Directory already exists.");
            }
            System.out.println("Exists: " + dirObj.exists());
            System.out.println("Name: " + dirObj.getName());
            System.out.println("Absolute Path: " + dirObj.getAbsolutePath());
            System.out.println("Length: " + dirObj.length());
            System.out.println("List: " + Arrays.toString(dirObj.list()));
            System.out.println();

            File fileObj = new File ("Files/source.txt");
            boolean isFileCreated = fileObj.createNewFile();
            if (isFileCreated) {
                System.out.println("File created: " + fileObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            System.out.println("Can read: " + fileObj.canRead());
            System.out.println("Can write: " + fileObj.canWrite());
            System.out.println("Exists: " + fileObj.exists());
            System.out.println("Name: " + fileObj.getName());
            System.out.println("Absolute Path: " + fileObj.getAbsolutePath());
            System.out.println("Length: " + fileObj.length());
            System.out.println();

            Scanner input = new Scanner(System.in);
            System.out.print("Text: ");
            String textInput = "";
            while(input.hasNextLine()) {
                String newText = input.nextLine();
                textInput = textInput + newText + "\n";
            }

            fileWriter = new FileWriter(fileObj);
            fileWriter.write(textInput); // writes the content to buffer
            fileWriter.flush(); // forcing to write content to file from buffer
            System.out.println("\n\nSuccessfully wrote to the file.");

            sc = new Scanner(fileObj);
            while(sc.hasNextLine()) {
                String text = sc.nextLine();
                System.out.println(text);
            }
            System.out.println();

            if (fileObj.delete()) {
                System.out.println("Deleted the file: " + fileObj.getName());
            } else {
                System.out.println("Failed to delete the file.");
            } 

            if (dirObj.delete()) {
                System.out.println("Deleted the directory: " + dirObj.getName());
            } else {
                System.out.println("Failed to delete the directory.");
            } 
        }
        catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
                if (sc != null) {
                    sc.close();
                }
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}