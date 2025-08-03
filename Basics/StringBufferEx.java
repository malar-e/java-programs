
import java.util.Arrays;

public class StringBufferEx {
    public static void main(String[] args) {
        // Constructors
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer(10);
        StringBuffer sb3 = new StringBuffer("gen digital");
        CharSequence cs1 = "norton lifelock";
        StringBuffer sb4 = new StringBuffer(cs1);
        CharSequence cs2 = new StringBuffer("avast");

        System.out.println("string buffer 1: " + sb1);
        System.out.println("string buffer 2: " + sb2);
        System.out.println("string buffer 3: " + sb3);
        System.out.println("string buffer 4: " + sb4);
        System.out.println("char sequence 1: " + cs1);
        System.out.println("char sequence 1: " + cs1.toString());
        System.out.println("char sequence 1: " + cs2);


        System.out.println("\n=== StringBuffer Methods ===");

        // charAt and setCharAt
        System.out.println("char at 3 in sb3: " + sb3.charAt(3));
        // setChatAt() - returns void. Except the setCharAt() method, all other methods that return both void and StringBuilder.
        sb3.setCharAt(3, 'a');
        System.out.println("after setCharAt(3, 'a'): " + sb3);

        // Using append
        StringBuffer sb = new StringBuffer();
        sb.append(true);                      // boolean
        sb.append('A');                       // char
        char[] chars = {'H', 'e', 'l', 'l', 'o'};
        sb.append(chars);                     // char[]
        sb.append(chars, 1, 3);               // char[] with offset and length → "ell"
        sb.append(3.14159);                   // double
        sb.append(2.718f);                    // float
        sb.append(42);                        // int
        sb.append(123456789L);                // long
        Object obj = new Person("Avast");
        sb.append(obj);                       // object
        Person person = new Person("John");
        sb.append(person);                    // Person obj
        sb.append(" Antivirus");              // string
        sb.append(new StringBuilder(" + StringBuilder"));  // StringBuilder
        sb.append(cs2);                       // CharSequence
        sb.append(cs2, 2, 5);                 // CharSequence partial → "ast"
        Integer[] array = {1,2,3};
        sb.append(array);                     // Array

        // More types
        short s = 120;
        byte b = 12;
        sb.append(s);

        System.out.println("final sb content: " + sb.append(b));

        // Capacity and length
        System.out.println("capacity of sb: " + sb.capacity());
        System.out.println("capacity of sb1: " + sb1.capacity());
        System.out.println("capacity of sb2: " + sb2.capacity()); 
        sb2.append("123456789650986");
        System.out.println("capacity of sb2 after adding string: " + sb2.capacity()); 
        System.out.println("capacity of sb3: " + sb3.capacity());
        System.out.println("length of sb: " + sb.length());

        // insert, reverse, delete, replace
        System.out.println("insert at index 3 in sb3: " + sb3.insert(3, "malar"));
        System.out.println("reverse sb3: " + sb3.reverse());
        System.out.println("delete from index 10 to 30 in sb: " + sb.delete(10, Math.min(30, sb.length())));
        sb3.replace(3, 8, "vizhi");
        System.out.println("replace 3 to 8 in sb3: " + sb3);

        // Convert to string
        String str = sb.toString();
        System.out.println("sb as string: " + str);
    }
}

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    // Override toString() so that appending this object prints the name
    @Override
    public String toString() {
        return "Person: " + name;
    }
}
