import java.util.Scanner;
import java.util.function.Function;

public class Functions {
    public static int add (int a, int b){
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        return a+b;
    }
    public static double add (double a, double b) {
        System.out.println("\na = " + a);
        System.out.println("b = " + b);
        return a+b;
    }
    public static int sum (int start, int end) {
        if(start<end) {
            return start+sum(start+1, end);
        } else {
            return start;
        }
    }

    public static Function<Integer, Integer> getDoubleAndAdd(Function<Integer, Integer> func) {
        // Returns a new function that doubles then applies 'func'
        return x -> func.apply(x * 2);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("=== Functions and Function Overloading ===");
        System.out.println("intSum: " + add(5,10));
        System.out.println("doubleSum: " + add(5.5,10.5));

        System.out.println("\n=== Recursion ===");
        System.out.print("Enter start: ");
        int start = sc.nextInt();
        System.out.print("Enter end: ");
        int end = sc.nextInt();
        System.out.println("sum: " + sum(start, end));

        Function<Integer, Integer> addTen = n -> n + 10;

        // Use higher-order function
        Function<Integer, Integer> doubleThenAdd = getDoubleAndAdd(addTen);

        int result = doubleThenAdd.apply(5); // (5 * 2) + 10 = 20

        System.out.println("Result = " + result);


    }


}
