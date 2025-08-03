public class Variables {
    int x = 50;
    public static void main(String[] args) {
        byte typeByte = 20;
        short typeShort = 20000;
        int typeInt = 20000000;
        long typeLong = 200000000L;
        char typeChar = 'A';
        char nullValue = '\0';
        char nullValue1 = 0;
        char nullValue2 = '\u0000';
        float typeFloat = 200.356f;
        double typeDouble = 200.2646636773d;
        boolean typeBoolean = true;
        String typeString = "Malar";
        int[] typeArray = {1,2,3};
        Variables typeObject = new Variables();

        System.out.println("=== Primitive Types ===");
        System.out.println("byte = " + typeByte);
        System.out.println("short = " + typeShort);
        System.out.println("int = " + typeInt);
        System.out.println("long = " + typeLong);
        System.out.println("char = " + typeChar);
        System.out.println("float = " + typeFloat);
        System.out.println("double = " + typeDouble);
        System.out.println("boolean = " + typeBoolean);
        System.out.println("\n=== Non-primitive Types ===");
        System.out.println("String = " + typeString);
        System.out.print("Array: ");
        for (int value : typeArray) {
            System.out.print(value + " ");
        }
        System.out.println("\nObject - Property of the object: " + typeObject.x);
        System.out.println("Null value: " + nullValue);
        System.out.println("Null value 1: " + nullValue1);
        System.out.println("Null value 2: " + nullValue2);

        System.out.println("\n=== Type casting ===");
        System.out.println("Widening type casting:");
        int myInt = 10;
        double myDouble = myInt;
        System.out.println("int = " + myInt);
        System.out.println("double = " + myDouble);
        System.out.println("Narrowing type casting:");
        int myInt1 = (int) myDouble;
        System.out.println("double = " + myDouble);   
        System.out.println("int = " + myInt1);

        System.out.println("=== with char and int ex ===");
        System.out.println("Widening type casting:");
        char c1='A';
        int i1=c1;
        System.out.println("char = " + c1);
        System.out.println("int = " + i1);
        System.out.println("Narrowing type casting:");
        int i2 = 66;
        char c2= (char)i2;//must specify type (cast)
        char c3 = 67;//no cast needed because it is literal
        System.out.println("int = " + i2);
        System.out.println("char = " + c2);
        System.out.println("char = " + c3);

    }
}

