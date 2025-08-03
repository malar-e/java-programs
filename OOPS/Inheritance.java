public class Inheritance {

    // static members are not inherited.
    public static void main(String[] args) {
        Dog dog1 = new Dog("Puppy", "Chicken");
        System.out.println(dog1.toString());
        System.out.println("Dog name is " + dog1.name + " eats " + dog1.food);
        Cat cat1 = new Cat("Luna", "White");
        System.out.println("Cat name is " + cat1.name + " looks " + cat1.color);
        dog1.sound();
        cat1.sound();
        System.out.println("Animal type is " + dog1.animalType);
        System.out.println();

        Animal dog2 = new Dog("Zoya", "Fish"); // Upcasting
        System.out.println("Dog name is " + dog2.name);
        Animal cat2 = new Cat("Kalix", "Black");
        System.out.println("Cat name is " + cat2.name);
        dog2.sound();
        cat2.sound();
        System.out.println("Animal type is " + cat2.animalType);
        System.out.println();

        Dog dog3 = (Dog) dog2; // Downcasting
        System.out.println("Dog name is " + dog3.name);
        System.out.println("Dog eats " + dog3.food);
        System.out.println("Animal type is " + dog3.animalType);
        dog3.sound();
        dog3.owner();
        System.out.println();

        BombayCat cat3 = new BombayCat("Misty", "Black", "Yellow");
        System.out.println("Bombay Cat name is " + cat3.name);
        System.out.println("Bombay Cat color is " + cat3.color);
        System.out.println("Bombay Cat eye color is " + cat3.eyeColor);
        cat3.sound();
        System.out.println("Animal type is " + cat3.animalType);
    }
}

class Animal {
    String name;
    String animalType = "Pet";

    public Animal(String name) {
        this.name = name;
    }

    void sound() {
        System.out.println("The animal makes sound");
    }
    public String toString() {
        return "Animal{name='" + name + "', animalType='" + animalType + "'}";
    }
}

class Dog extends Animal {
    String food;

    public Dog(String name, String food) {
        super(name);
        this.food = food;
    }

    @Override
    void sound() {
        super.sound();
        System.out.println("The " + animalType + " " + name + " dog says: bow bow");
    }

    void owner() {
        System.out.println("The owner of " + name + " is malar");
    }
    public String toString() {
        return super.toString() + ", Dog{food='" + food + "'}";
    }
}

class Cat extends Animal {
    String color;

    public Cat(String name, String color) {
        super(name);
        this.color = color;
    }

    @Override
    void sound() {
        super.sound();
        System.out.println("The " + animalType + " " + name + " cat says: meow meow");
    }
}

class BombayCat extends Cat {
    String eyeColor;

    public BombayCat(String name, String color, String eyeColor) {
        super(name, color);
        this.eyeColor = eyeColor;
    }
}
