import java.util.Arrays;
import java.util.*;

public class ObjectArrayEx {
    public static void main(String[] args){
        Object[] objArray1 = new Object[12];
        objArray1[0] = "Hello";
        objArray1[1] = 123;
        objArray1[2] = 45.67f;
        objArray1[3] = true;
        objArray1[4] = new int[]{1, 2, 3};
        objArray1[5] = new Person("John", 30);
        objArray1[6] = 'A';
        objArray1[7] = 45.7554433d;
        objArray1[8] = 1234L;
        objArray1[9] = (byte) 100;
        objArray1[10] = (short) 1000;
        objArray1[11] = new ArrayList<>();


        for (Object obj : objArray1) {
            if (obj instanceof String) {
                String str = (String) obj;
                System.out.println("String: " + obj + ", length: " + str.length());
            } else if (obj instanceof Integer) {
                int intVal = (Integer) obj;
                System.out.println("Integer: " + obj + ", binaryString: " + Integer.toBinaryString(intVal));
            } else if (obj instanceof Double) {
                Double doubleVal = (Double) obj;
                System.out.println("Double: " + doubleVal);
            } else if (obj instanceof Boolean) {
                boolean boolVal = (Boolean) obj;
                System.out.println("Boolean: " + boolVal);
            } else if (obj instanceof Character) {
                int charVal = (Character) obj;
                System.out.println("Character: " + obj + ", ASCII value: " + charVal);
            } else if (obj instanceof Float) {
                float doubleVal = (Float) obj;
                System.out.println("Float: " + obj);
            } else if (obj instanceof Long) {
                Long longVal = (Long) obj;
                System.out.println("Long: " + obj + ", hexString: " + Long.toHexString(longVal));
            } else if (obj instanceof int[]) {
                System.out.println("int[]: " + Arrays.toString((int[]) obj));
            } else if (obj instanceof Person) {
                Person person = (Person) obj;
                System.out.println("Person: Name = " + person.name + ", Age = " + person.age);
            } else if (obj instanceof Byte) {
                System.out.println("Byte: " + obj);
            } else if (obj instanceof Short) {
                int intVal = (Short) obj;
                System.out.println("Short: " + obj + ", octalString: " + Integer.toOctalString(intVal));
            } else if (obj instanceof List) {
                System.out.println("List: " + obj);
                List<Integer> list = (List<Integer>) obj;
                list.add(8);
                System.out.println("List after adding value: " + list);
            } else {
                System.out.println("Unknown: " + obj);
            }
        }

        Object[] objArray2 = new Object[12];
        objArray2[0] = objArray1[0]; // this stores reference not value since it is object.
        objArray2[1] = objArray1[1];
        objArray2[2] = objArray1[2];
        objArray2[3] = objArray1[3];
        objArray2[4] = objArray1[4];
        objArray2[5] = objArray1[5];
        objArray2[6] = objArray1[6];
        objArray2[7] = objArray1[7];
        objArray2[8] = objArray1[8];
        objArray2[9] = objArray1[9];
        objArray2[10] = objArray1[10];
        objArray2[11] = objArray1[11];

        Object[] objArray3 = objArray1;
        System.out.println("\nobjArray1 == objArray2: " + (objArray1 == objArray2));
        System.out.println("objArray1 == objArray3: " + (objArray1 == objArray3));
        System.out.println("Object Arrays equal? " + Arrays.deepEquals(objArray1, objArray2));
        System.out.println("Object Arrays equal? " + Arrays.deepEquals(objArray1, objArray3));
        System.out.println("MD Array HashCode: " + Arrays.deepHashCode(objArray1));
        System.out.println("MD Array toString: " + Arrays.deepToString(objArray1));

    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
