import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        tryCatch();
        tryWithResource();
        customException();
        customRuntimeException();
        customError();
    }

    public static void tryCatch() {
        System.out.println("=== try...catch...finally ===");
        MyResource obj = null;
        try {
            obj = new MyResource();
            obj.doSomething();
            System.out.println();

            int[] arr = {1,2,3,4,5};
            System.out.println(arr[8]);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        finally {
            System.out.println("\nThe 'try catch' is finished.");
            obj.close();
        }

    }

    public static void customError() {
        System.out.println("\n=== custom error using throw ===");
        Scanner sc = new Scanner(System.in);
        System.out.print("Age: ");
        int age = sc.nextInt();
        if(age < 18) {
            throw new ArithmeticException("Access denied - You must be at least 18 years old to vote.");
        } else {
            System.out.println("Access granted - You are old enough to vote!");
        }
    }

    public static void tryWithResource() {
        System.out.println("\n=== try with resource ===");
        try (MyResource obj = new MyResource()) {
            obj.doSomething();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void customException() {
        System.out.println("\n=== custom exceptions ===");
        try {
            validateAge(5);
            validateAge(-5);
        } catch (MyCustomException e) {
            System.out.println("Caught custom checked exception: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Caught general exception: " + e.getMessage());
        }
    }

    public static void customRuntimeException() {
        try {
            validateName(null);
        } catch (MyCustomRuntimeException e) {
            System.out.println("Caught custom checked exception: " + e.getMessage());
        }
    }

    public static void validateAge (int age) throws MyCustomException {
        if(age < 0) {
            throw new MyCustomException("Age cannot be negative");
        }
        System.out.println("Valid age: "+age);
    }

    public static void validateName(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new MyCustomRuntimeException("Name cannot be null or empty");
        }
        System.out.println("Valid name: " + name);
    }

}

class MyResource implements AutoCloseable {
    public MyResource() {
        System.out.println("Resource opened!");
    }
    public void doSomething() {
        System.out.println("Using resource...");
    }
    @Override
    public void close() {
        System.out.println("Resource closed automatically!");
    }
}

class MyCustomException extends Exception {
    public MyCustomException(String message) {
        super(message);
    }
}

class MyCustomRuntimeException extends RuntimeException {
    public MyCustomRuntimeException(String message) {
        super(message);
    }
}

