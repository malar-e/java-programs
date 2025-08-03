public class InheritanceDemo {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Car("Toyota", 120, "Petrol");
        Vehicle vehicle2 = new Bike("Yamaha", 90, "Petrol");
        Vehicle vehicle3 = new Truck("Volvo", 80, "Diesel");

        vehicle1.start();
        vehicle2.start();
        vehicle3.start();

        System.out.println();

        if (vehicle1 instanceof Car) {
            Car car = (Car) vehicle1;
            car.openTrunk();
        }
    }
}

// Base class
class Vehicle {
    String brand;
    int speed;
    String fuelType;

    public Vehicle(String brand, int speed, String fuelType) {
        this.brand = brand;
        this.speed = speed;
        this.fuelType = fuelType;
    }

    void start() {
        System.out.println(brand + " is starting...");
    }

    void refuel() {
        System.out.println("Refueling " + brand + " with " + fuelType);
    }
}

// Child class - Car
class Car extends Vehicle {
    public Car(String brand, int speed, String fuelType) {
        super(brand, speed, fuelType);
    }

    @Override
    void start() {
        System.out.println("Car " + brand + " starts with a key. Speed: " + speed + "km/h");
    }

    void openTrunk() {
        System.out.println("Opening the trunk of " + brand);
    }
}

// Child class - Bike
class Bike extends Vehicle {
    public Bike(String brand, int speed, String fuelType) {
        super(brand, speed, fuelType);
    }

    @Override
    void start() {
        System.out.println("Bike " + brand + " starts with a kick or button.");
    }
}

// Child class - Truck
class Truck extends Vehicle {
    public Truck(String brand, int speed, String fuelType) {
        super(brand, speed, fuelType);
    }

    @Override
    void start() {
        System.out.println("Truck " + brand + " starts with a heavy-duty ignition.");
    }
}
