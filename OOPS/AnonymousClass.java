
public class AnonymousClass {
    public static void main(String[] args) {
        // Anonymous class extending an abstract class - static fields and methods not allowed
        MyAbstractClass abstractObj = new MyAbstractClass() {
            int value = 1;
            @Override
            void greet() {
                System.out.println("Hello from abstract class! " + value);
            }

            @Override
            void farewell() {
                System.out.println("Goodbye from abstract class! " + value);
            }
        };

        abstractObj.greet();
        abstractObj.farewell();

        // Anonymous class implementing an interface - static fields and methods not allowed
        MyInterface interfaceObj = new MyInterface() {
            int value = 2;

            @Override
            public void start() {
                System.out.println("Starting from interface! " + value);
            }

            @Override
            public void stop() {
                System.out.println("Stopping from interface! " + value);
            }
        };

        interfaceObj.start();
        interfaceObj.stop();
    }
}

abstract class MyAbstractClass {
    abstract void greet();
    abstract void farewell();
}

interface MyInterface {
    void start();
    void stop();
}

