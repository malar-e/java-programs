public class WrapperClass {
    public static void main(String[] args) {

        System.out.println("Boxing: int -> Integer");
        Byte myByte = (byte) 45; // default int, so cast needed
        Short myShort = (short) 500;
        Integer myInt = 4500;
        Long myLong = (long) 23; // default int, so suffix 'L' needed or cast needed
        Float myFloat = 4.56f; // default double, so suffix 'f' needed or cast needed
        Double myDouble = 56.765;
        Character myChar = 'A';
        Boolean myBool = true;

        System.out.println("Unboxing: Integer -> int");
        byte byteVal = myByte;
        short shortVal = myShort;
        int intVal = myInt;
        long longVal = myLong;
        float floatVal = myFloat;
        double doubleVal = myDouble;
        char charVal = myChar;
        boolean boolVal = myBool;

        // Print auto-boxed and unboxed values
        System.out.println("Auto-Boxed values:");
        System.out.println("Byte: " + myByte);
        System.out.println("Short: " + myShort);
        System.out.println("Integer: " + myInt);
        System.out.println("Long: " + myLong);
        System.out.println("Float: " + myFloat);
        System.out.println("Double: " + myDouble);
        System.out.println("Character: " + myChar);
        System.out.println("Boolean: " + myBool);

        System.out.println("\nString lengths of auto-boxed values:");
        System.out.println("Byte: " + myByte.toString() + " (Length: " + myByte.toString().length() + ")");
        System.out.println("Short: " + myShort.toString() + " (Length: " + myShort.toString().length() + ")");
        System.out.println("Integer: " + myInt.toString() + " (Length: " + myInt.toString().length() + ")");
        System.out.println("Long: " + myLong.toString() + " (Length: " + myLong.toString().length() + ")");
        System.out.println("Float: " + myFloat.toString() + " (Length: " + myFloat.toString().length() + ")");
        System.out.println("Double: " + myDouble.toString() + " (Length: " + myDouble.toString().length() + ")");
        System.out.println("Character: " + myChar.toString() + " (Length: " + myChar.toString().length() + ")");
        System.out.println("Boolean: " + myBool.toString() + " (Length: " + myBool.toString().length() + ")");

        System.out.println("\nAuto-Unboxed values:");
        System.out.println("byte: " + byteVal);
        System.out.println("short: " + shortVal);
        System.out.println("int: " + intVal);
        System.out.println("long: " + longVal);
        System.out.println("float: " + floatVal);
        System.out.println("double: " + doubleVal);
        System.out.println("char: " + charVal);
        System.out.println("boolean: " + boolVal);

        System.out.println("\nManual Boxing using valueOf():");
        Byte mByte = Byte.valueOf((byte) 12);
        Short mShort = Short.valueOf((short) 1000);
        Integer mInt = Integer.valueOf(12345);
        Long mLong = Long.valueOf(1239L);
        Float mFloat = Float.valueOf(9.87f);
        Double mDouble = Double.valueOf(123.456);
        Character mChar = Character.valueOf('Z');
        Boolean mBool = Boolean.valueOf(false);


        Byte mByte1 = (Byte) ((byte) 12);
        Short mShort1 = (Short) ((short) 1000);
        Integer mInt1 = (Integer) 12345;
        Long mLong1 = (Long) 1239L;
        Float mFloat1 = (Float) 9.87f;
        Double mDouble1 = (Double) 123.456;
        Character mChar1 = (Character) 'Z';
        Boolean mBool1 = (Boolean) false;

        System.out.println("Manually Boxed values using valueOf():");   
        System.out.println("Byte: " + mByte);
        System.out.println("Short: " + mShort);
        System.out.println("Integer: " + mInt);
        System.out.println("Long: " + mLong);
        System.out.println("Float: " + mFloat);
        System.out.println("Double: " + mDouble);
        System.out.println("Character: " + mChar);
        System.out.println("Boolean: " + mBool);

        System.out.println("\nManually Boxed values using typeCast:");
        System.out.println("Byte: " + mByte1);
        System.out.println("Short: " + mShort1);
        System.out.println("Integer: " + mInt1);
        System.out.println("Long: " + mLong1);
        System.out.println("Float: " + mFloat1);
        System.out.println("Double: " + mDouble1);
        System.out.println("Character: " + mChar1);
        System.out.println("Boolean: " + mBool1);

        System.out.println("\nManual Unboxing using xxxValue():");
        byte b = mByte.byteValue();
        short s = mShort.shortValue();
        int i = mInt.intValue();
        long l = mLong.longValue();
        float f = mFloat.floatValue();
        double d = mDouble.doubleValue();
        char c = mChar.charValue();
        boolean bool = mBool.booleanValue();

        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        System.out.println("char: " + c);
        System.out.println("boolean: " + bool);

        System.out.println("\n=== Binary, Hex and Octal values of Numbers ===");

        // For myByte
        System.out.println("\nByte: " + myByte);
        int intValOfByte = myByte; // automatically unbox and widening type cast the obj.
        System.out.println("Byte -> Binary: " + Integer.toBinaryString(intValOfByte));
        System.out.println("Byte -> Hex: " + Integer.toHexString(intValOfByte));
        System.out.println("Byte -> Octal: " + Integer.toOctalString(intValOfByte));

        // For myShort
        System.out.println("\nShort: " + myShort);
        int intValOfShort = myShort.shortValue();
        System.out.println("Short -> Binary: " + Integer.toBinaryString(intValOfShort));
        System.out.println("Short -> Hex: " + Integer.toHexString(intValOfShort));
        System.out.println("Short -> Octal: " + Integer.toOctalString(intValOfShort));

        // For myInt
        System.out.println("\nInt: " + myInt);
        System.out.println("Integer -> Binary: " + Integer.toBinaryString(myInt));
        System.out.println("Integer -> Hex: " + Integer.toHexString(myInt.intValue()));
        System.out.println("Integer -> Octal: " + Integer.toOctalString(myInt));

        // For myLong
        System.out.println("\nLong: " + myLong);
        System.out.println("Long -> Binary: " + Long.toBinaryString(myLong));
        System.out.println("Long -> Hex: " + Long.toHexString(myLong.longValue()));
        System.out.println("Long -> Octal: " + Long.toOctalString(myLong));

        Double add = myByte + myShort + myInt + myLong + myFloat + myDouble;  // This auto unbox to primitive, calculates the output and auto box to Double
        System.out.println("Add: " + add);

        Integer int1 = 10;
        Integer int2 = int1;
        System.out.println("int1 == int2? " + (int1 == int2)); // true, because both refer to same object in Integer cache
        System.out.println("int1.equals(int2)? " + (int1.equals(int2)));
        System.out.println("int1.compareTo(int2)? " + (int1.compareTo(int2)));
        Integer int3 = 200;
        Integer int4 = 200;
        System.out.println("int3 == int4? " + (int3 == int4)); // false, because 200 is outside of Integer cache range(-127 to 128), so new objects are created
        System.out.println("int3.equals(int4)? " + (int3.equals(int4)));
        Integer int5 = 20;
        Integer int6 = 20;
        System.out.println("int5 == int6? " + (int5 == int6)); // true, because both refer to same object in Integer cache
        System.out.println("int5.equals(int6)? " + (int5.equals(int6)));

        // Except Integer all other wrapper classes behaves like other objects for "=="
        Double db1 = 10.0;
        Double db2 = db1;
        System.out.println("db1 == db2? " + (db1 == db2));
        System.out.println("db1.equals(db2)? " + (db1.equals(db2)));
        Double db3 = 200.0;
        Double db4 = 200.0;
        System.out.println("db3 == db4? " + (db3 == db4));
        System.out.println("db3.equals(db4)? " + (db3.equals(db4)));
        System.out.println("db3.compareTo(db4)? " + (db3.compareTo(db4)));

        System.out.println("Compare two integers(3, 4): " + Integer.compare(3, 4));
        System.out.println("Compare two doubles(3.0, 4.0): " + Double.compare(3.0, 4.0));
        System.out.println("Compare two booleans(true, false): " + Boolean.compare(true, false));
        System.out.println("Compare two characters('a', 'b'): " + Character.compare('a', 'b'));

}
}
