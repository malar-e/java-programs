import java.util.Arrays;
import java.util.*;

public class VariableType {
    public static void main(String[] args) {
        byte typeByte = 20;
        short typeShort = 20000;
        int typeInt = 20000000;
        long typeLong = 200000000L;
        char typeChar = 'A';
        float typeFloat = 200.356f;
        double typeDouble = 200.2646636773d;
        boolean typeBoolean = true;
        Integer typeInteger = 100;
        String typeString = "Malar";
        short[] typeArray = {1, 2, 3};
        Integer[] wcArray = {1, 2, 3};
        Person obj = new Person("John", 30);
        List<Integer> list = new ArrayList<>(Arrays.asList(wcArray));

        // Boxing primitives to use getClass()
        System.out.println("byte: " + ((Byte)typeByte).getClass().getName());
        System.out.println("short: " + ((Object)typeShort).getClass().getName());
        System.out.println("int: " + ((Integer)typeInt).getClass().getName());
        System.out.println("long: " + ((Long)typeLong).getClass().getName());
        System.out.println("char: " + ((Object)typeChar).getClass().getName());
        System.out.println("float: " + ((Float)typeFloat).getClass().getName());
        System.out.println("double: " + ((Object)typeDouble).getClass().getName());
        System.out.println("boolean: " + ((Boolean)typeBoolean).getClass().getName());

        // Directly using getClass() for object types
        System.out.println("Integer: " + typeInteger.getClass().getName());
        System.out.println("String: " + typeString.getClass().getName());
        System.out.println("Array: " + typeArray.getClass().getName());
        System.out.println("WC Array: " + wcArray.getClass().getName());
        System.out.println("Person object: " + obj.getClass().getName());
        System.out.println("Person object: " + list.getClass().getName());
    }
}

class Person {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
