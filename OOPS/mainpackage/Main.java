package mainpackage;
import mypackage.CarClass;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        System.out.println("\n=== Car Class ===");
        System.out.println("\n=== Create Car with only color (use default weight) ===");
        CarClass obj1= new CarClass("Black");
        System.out.println("Color of the car is " +obj1.color);
        System.out.println("Weight of the car is " +obj1.weight);
        System.out.println("Speed of the car is " +obj1.speed(200));
        System.out.println(obj1.toString());

        System.out.println("\n=== Create Car with color and weight ===");
        CarClass obj2= new CarClass("White", 200);
        System.out.println("Color of the car is " +obj2.color);
        System.out.println("Weight of the car is " +obj2.weight);
        System.out.println("Speed of the car is " +obj2.speed(100));
        System.out.println(obj2.toString());
    }
}