
public class EnumInterfaceDemo {
    public static void main(String[] args) {
        int a = 10, b = 5;

        for (MathOperation op : MathOperation.values()) {
            System.out.println("Value: " + op.getValue());
            System.out.println(op + ": " + op.apply(a, b));
            System.out.println("Priority: " + op.getPriority());
            System.out.println();
        }

    }
}

enum MathOperation implements Operation {

    ADD { // anonymous class so static fields and methods not allowed
        int value = 1;
        
        @Override
        public int getValue() {
            return value;
        }

        @Override
        public int apply(int a, int b) {
            return a + b;
        }

        @Override
        public int getPriority() {
            return value;
        }



    },
    SUBTRACT {
        int value = 2;

        @Override
        public int getValue() {
            return value;
        }

        @Override
        public int apply(int a, int b) {
            return a - b;
        }

        @Override
        public int getPriority() {
            return value;
        }
    },
    MULTIPLY {
        int value = 3;

        @Override
        public int getValue() {
            return value;
        }

        @Override
        public int apply(int a, int b) {
            return a * b;
        }

        @Override
        public int getPriority() {
            return value;
        }
    },
    DIVIDE {
        int value = 4;

        @Override
        public int getValue() {
            return value;
        }

        @Override
        public int apply(int a, int b) {
            if (b == 0) throw new ArithmeticException("Cannot divide by zero");
            return a / b;
        }

        @Override
        public int getPriority() {
            return value;
        }
    };

    public abstract int getValue(); // all enum constants are required to override the abstract method.


}


interface Operation {
    int apply(int a, int b);
    int getPriority();
}

