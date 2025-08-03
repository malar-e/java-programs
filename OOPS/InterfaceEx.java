public class InterfaceEx {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.getStaticValues();
        System.out.println(dog1.toString());
        System.out.println();

        Animal dog = dog1;//upcasting
        dog.sound();
        dog.sleep();
        dog.food();
        System.out.println(dog.toString());
    }
}
interface Animal {
    String TYPE = "Wild Animal";
    public void sound();
    void sleep();
    default void food () {
        System.out.println("The animal eats meat");
    }
    static void color() {
        System.out.println("The animal color is brown");
    }
    // we cant override toString() here. Because not allowed.
}
class Dog implements Animal {
    String name = "Puppy";
    void getStaticValues() {
        System.out.println(TYPE);  // we can access static field without interface name when the interface is implememted in the class.
        Animal.color();
    }
    public void sound() {
        System.out.println("The dog says bow bow");
    }
    public void sleep() {
        System.out.println("Zzz");
    }
    public void food () {
         System.out.println("The animal eats milk");
    }
    @Override
    public String toString() {
        return "Dog [ name = "+name+" ]";
    }
}