public class Abstraction {
    public static void main (String[] args) {
        Cat cat = new Cat("Tomy");
        System.out.println("Cat name is "+cat.name);
        cat.sound();
        cat.sleep();
        cat.color();
        System.out.println();

        Dog dog = new Roman("Puppy");
        System.out.println("Dog name is "+dog.name);
        dog.sound();
        dog.sleep();
        dog.color();

        System.out.println("\n"+Dog.getName());
    }
}
abstract class Animal {
    String name;
    Animal(String name) {
        this.name = name;
    }
    abstract void sound();
    abstract void color();
    public void sleep() {
    System.out.println("Zzz");
  }
}
abstract class Dog extends Animal {
    static String name = "dog";
    static String getName() {
        return name;
    }
    Dog(String name) {
        super(name);
    }
    void color() {
        System.out.println("Dog color is brown");
    }
    abstract void food();
}
class Roman extends Dog {
    Roman(String name) {
        super(name);
    }
    void sound()  {
        System.out.println("The dog says: bow bow");
    }
    void food() {
        System.out.println("Roman eats chicken");
    }
}
class Cat extends Animal {
    Cat(String name) {
        super(name);
    }
    void color() {
        System.out.println("Cat color is black");
    }
    void sound() {
        System.out.println("The cat says: meow meow");
    }
}