public class InnerClassEx {
    public static void main(String[] args) {
        OuterClass1 oc1 = new OuterClass1();
        OuterClass1.InnerClass1 ic1 = oc1.new InnerClass1(20);
        ic1.display();
        OuterClass1.InnerClass1.display1();
        System.out.println("z = "+OuterClass1.InnerClass1.z);
        System.out.println();

        OuterClass2 oc2 = new OuterClass2();
        oc2.getInstance();
        System.out.println();

        OuterClass3 oc3 = new OuterClass3();
        OuterClass3.InnerClass3 ic3 = new OuterClass3.InnerClass3(20);
        ic3.display();
        OuterClass3.InnerClass3.display1();
        System.out.println("z = "+OuterClass3.InnerClass3.z);
    }
}

class OuterClass1 {
    int x = 10;
    class InnerClass1 {
        static int z;
        int y;
        InnerClass1(int y) {
            this.y = y;
            z++;
            System.out.println("=== default inner and outer class ===");
        }
        void display() {
            System.out.println("Hello from default Inner's instance method");
            System.out.println("x = " + x);
        }
        static void display1 () {
            System.out.println("Hello from default Inner's static method");
        }
    }
}

class OuterClass2 {
    int x=10;
    private class InnerClass2 {
        static int z;
        int y;
        InnerClass2(int y) {
            this.y = y;
            z++;
            System.out.println("=== default inner and private outer class ===");
        }
        void display() {
            System.out.println("Hello from private Inner's instance method");
            System.out.println("x = " + x);
        }
        static void display1() {
            System.out.println("Hello from private Inner's static method");
        }
    }
    void getInstance() {
        InnerClass2 ic2 = new InnerClass2(20);
        ic2.display();
        InnerClass2.display1();
        System.out.println("z = "+InnerClass2.z);
    }
}

class OuterClass3 {
    int x = 10;
    static class InnerClass3 {
        static int z;
        int y;
        InnerClass3 (int y) {
            this.y = y;
            z++;
            System.out.println("=== default inner and static outer class ===");
        }
        void display() {
            System.out.println("Hello from static Inner's instance method");
        }
        static void display1() {
            System.out.println("Hello from static Inner's static method");
        }
    }
}