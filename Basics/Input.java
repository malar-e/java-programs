import java.util.Scanner;

public class Input {
    public static void main(String[] args){
       System.out.println("=== local variables must be initialized ===");
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter a byte value: ");
       byte b = sc.nextByte();

       System.out.print("Enter a short value: ");
       short s = sc.nextShort();

       System.out.print("Enter a int value: ");
       int i = sc.nextInt();

       System.out.print("Enter a long value: ");
       long l = sc.nextLong();

       System.out.print("Enter a float value: ");
       float f = sc.nextFloat();

       System.out.print("Enter a double value: ");
       double d = sc.nextDouble();

       System.out.print("Enter a boolean value: ");
       boolean b1 = sc.nextBoolean();

       System.out.print("Enter a char: ");
       char c = sc.next().charAt(0);

       System.out.print("Enter a String (word): "); // takes one word
       String s1 = sc.next();

       sc.nextLine(); // consumes leftover newline

       System.out.print("Enter a String (line): "); // takes entire line
       String s2 = sc.nextLine();

       System.out.println("\n=== Inputs ===");
       System.out.println("byte: " + b);
       System.out.println("short: " + s);
       System.out.println("int: " + i);
       System.out.println("long: " + l);
       System.out.println("float: " + f);
       System.out.println("double: " + d);
       System.out.println("char: " + c);
       System.out.println("String (word): " + s1);
       System.out.println("String (line): " + s2);

    }
}