package mypackage;

public class CarClass {
    public String color;
    public int weight;
    public CarClass (String color) {
        this (color, 100);
    }
    public CarClass (String color, int weight) {
        this.color = color;
        this.weight = weight;
    }
    public int speed (int speed) {
        return speed;
    }

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

        System.out.println();

        useCar();
    }

    public static void useCar () {

        Car obj = new Car();
        obj.setName("BMW");
        obj.setCategory('A');
        System.out.println("Car name is "+obj.getName());
        System.out.println("Car category is "+obj.getCategory());
        System.out.println(obj);
    }
}