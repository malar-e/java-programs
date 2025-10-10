import java.util.*;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaEx {

    public static void main(String[] args) {

        // Without Lambda: Anonymous class
        StringFunction exclaim = new StringFunction() {
            private final String ask = "?";
            static final String DOLLAR = "$";

            public String apply(String str) {
                return str + "!" + ask + DOLLAR;
            }
        };
        System.out.println("Without Lambda: " + exclaim.apply("Hello"));

        // With Lambda: basic usage
        StringFunction question = str -> str + "?";
        System.out.println("With Lambda (question): " + question.apply("Hello"));

        StringFunction dollar = str -> str + "$";
        System.out.println("With Lambda (dollar): " + dollar.apply("Hello") + "\n");

        // variable capture 
        for (String s : Arrays.asList("Hello", "World")) {
            StringFunction add = str -> str + s;
            System.out.println("With Lambda: " + add.apply("fun "));
        }

        for (String s : Arrays.asList("Hello", "World")) {
            StringFunction add = new StringFunction() {
                public String apply(String str) {
                    return str + s;
                }
            };
            System.out.println("With Lambda: " + add.apply("fun "));
        }

        for (String s : Arrays.asList("Hello", "World")) {
            StringFunction add = new VarCapture1(s);
            System.out.println("With Lambda: " + add.apply("fun "));
        }

        System.out.println("\nUsing Higher Order function: " + addingStrings("Hello", question));

        // Lambda for functional interface with no parameters
        Animal dog = () -> System.out.println("Dog says boww bowww...");
        System.out.println("\nAnimal type: " + Animal.TYPE);
        dog.sound();
        dog.food();
        Animal.color();

        // Passing lambda as object
        System.out.println("\nLambda as object:");
        doSomething(dog);

        // Lambda capturing variables
        VarCapture capture = new VarCapture();
        capture.show();

        // Method Reference: println (Static method reference)
        System.out.println("\nMethod Reference - println:");
        MyPrinter printer = System.out::println;
        printer.print();
        MyIntegerPrinter intPrinter = System.out::println;
        intPrinter.print(4);

        // Method Reference: static method
        System.out.println("\nMethod Reference - static method:");
        Finder staticFinder = FinderUtils::findIndex;
        int index = staticFinder.find("Hello World", "World");
        System.out.println("Index of 'World': " + index);

        // Method Reference: parameter method (instance method of class)
        System.out.println("\nParameter Method Reference:");
        Finder compare = String::compareTo;
        int compareVal = compare.find("apple", "banana");
        System.out.println("Compare value: " + compareVal);

        // Instance method reference of specific object
        System.out.println("\nInstance Method Reference:");
        InstanceRefer ir = capture::show;
        ir.execute();

        // Constructor reference
        System.out.println("\nConstructor Reference:");
        VarCaptureCreator creator = VarCapture::new;
        VarCapture newCapture = creator.create();
        newCapture.show();

        // Constructor reference for String
        StringCreator strCreator = String::new;
        String newStr = strCreator.create(new char[]{'m', 'a', 'l', 'a', 'r'});
        System.out.println("Created String: " + newStr);

        // Additional Examples
        methodReferenceExample();
        consumerExample();
        functionExample();
    }

    static void doSomething(Animal animal) {
        animal.sound();
        animal.food();
        Animal.color();
    }

    public static void methodReferenceExample() {
        System.out.println("\nList printing using method reference:");
        List<String> list = Arrays.asList("Java", "Python", "C++");
        list.forEach(System.out::println);
    }

    public static void consumerExample() {
        System.out.println("\nUsing Consumer functional interface:");
        List<String> list = Arrays.asList("Java", "Python", "C++");
        Consumer<String> consumer = s -> System.out.println(s);
        list.forEach(consumer);
    }

    public static void functionExample() {
        System.out.println("\nUsing Function with var:");
        Function<String, String> function = (var s) -> s.toUpperCase();
        System.out.println(function.apply("hello"));
    }

    public static String addingStrings (String str, StringFunction strFun) { // Higher order function
        return strFun.apply(str);
    }
}

// Functional interface for String lambda
interface StringFunction {
    String apply(String str);
}

// Functional interface for Animal behavior
interface Animal {
    String TYPE = "Pet Animal";
    void sound();

    default void food() {
        System.out.println("The animal eats meat.");
    }

    static void color() {
        System.out.println("The animal color is brown.");
    }
}

// Demonstrates variable capture in lambdas
class VarCapture {
    String instanceVar = "Instance "; // can be modified
    static String staticVar = "Static "; // can be modified

    void show() {
        String localVar = "Local "; // can't be modified
        StringFunction func = str -> str + instanceVar + staticVar + localVar;
        System.out.println(func.apply("Hello "));
    }
}

// Functional interface for method reference with return value
interface Finder {
    int find(String s1, String s2);
}

class FinderUtils {
    static int findIndex(String s1, String s2) {
        return s1.lastIndexOf(s2);
    }
}

// Functional interfaces for method/constructor reference
interface InstanceRefer {
    void execute();
}

interface MyPrinter {
    void print();
}

interface MyIntegerPrinter {
    void print(int value);
}

interface VarCaptureCreator {
    VarCapture create();
}

interface StringCreator {
    String create(char[] arr);
}

class VarCapture1 implements StringFunction{
    String var;

    VarCapture1(String var) {
        this.var = var;
    }

    @Override
    public String apply(String str) {
        return str + var;
    }

}
