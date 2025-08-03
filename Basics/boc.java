public class boc {
    {
        System.out.println ("instance block of code");
    }
    static {
        System.out.println ("static block of code");
    }

    public static void main(String[] args){
        boc obj1 = new boc();
        System.out.println();

        ex.display();
        ex obj2 = new ex();

    }
}
class ex {
    {
        System.out.println ("instance block of code");
    }
    static {
        System.out.println ("static block of code");
    }
    static void display() {
        System.out.println ("display method");
    }
}
// The main class (the one with public static void main(String[] args)) is loaded into memory by JVM when you run the program. Other classes are loaded only when they are first needed.