public class Operators {
    public static void main(String[] args) {
        System.out.println("=== Operators ===");
        
        System.out.println("\n=== Arithmetic Operators ===");
        int a = 10, b = 3;
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("Addition (a + b): " + (a + b));
        System.out.println("Subtraction (a - b): " + (a - b));
        System.out.println("Multiplication (a * b): " + (a * b));
        System.out.println("Division (a / b): " + (a / b));
        System.out.println("Modulus (a % b): " + (a % b));

        System.out.println("\n=== Bitwise Operators ==="); // it wont work for floating numbers.
        short m = 65;
        short n = 66;
        System.out.println("m = " + m + " (Binary: " + Integer.toBinaryString(m) + ")");
        System.out.println("n = " + n + " (Binary: " + Integer.toBinaryString(n) + ")");
        System.out.println("m & n (AND): " + (m & n) + " (Binary: " + Integer.toBinaryString(m & n) + ")");
        System.out.println("m | n (OR): " + (m | n) + " (Binary: " + Integer.toBinaryString(m | n) + ")");
        char m1 = 'A';
        char n1 = 66;
        System.out.println("m ^ n (XOR): " + (m1 ^ n1) + " (Binary: " + Integer.toBinaryString(m1 ^ n1) + ")");
        System.out.println("~m (NOT): " + (~m1) + " (Binary: " + Integer.toBinaryString(~m1) + ")");
        long m2 = 65;
        long n2 = 66;
        System.out.println("m << 2 (Left Shift): " + (m2 << 2) + " (Binary: " + Long.toBinaryString(m2 << 2) + ")");
        System.out.println("m >> 2 (Signed Right Shift): " + (m2 >> 2) + " (Binary: " + Long.toBinaryString(m2 >> 2) + ")");
        System.out.println("m >>> 2 (Unsigned Right Shift): " + (m2 >>> 2) + " (Binary: " + Long.toBinaryString(m2 >>> 2) + ")"); // treats negative as positive

        System.out.println("\n=== Assignment Operators ===");
        int x = 5;
        System.out.println("Initial x = " + x);
        x += 3;
        System.out.println("After x += 3: " + x);
        x -= 2;
        System.out.println("After x -= 2: " + x);
        x *= 2;
        System.out.println("After x *= 2: " + x);
        x /= 3;
        System.out.println("After x /= 3: " + x);
        x %= 3;
        System.out.println("After x %= 3: " + x);
        x &= 3;
        System.out.println("After x &= 3: " + x);
        x |= 3;
        System.out.println("After x |= 3: " + x);
        x ^= 3;
        System.out.println("After x ^= 3: " + x);
        x <<= 3;
        System.out.println("After x <<= 3: " + x);
        x >>= 3;
        System.out.println("After x >>= 3: " + x);
        x >>>= 3;
        System.out.println("After x >>>= 3: " + x);
        
        System.out.println("\n=== Comparison or Relational Operators ===");
        int p = 15, q = 10;
        System.out.println("p = " + p + ", q = " + q);
        System.out.println("p == q: " + (p == q));
        System.out.println("p != q: " + (p != q));
        System.out.println("p > q: " + (p > q));
        System.out.println("p < q: " + (p < q));
        System.out.println("p >= q: " + (p >= q));
        System.out.println("p <= q: " + (p <= q));
        
        System.out.println("\n=== Logical Operators ===");
        boolean bool1 = true, bool2 = false;
        System.out.println("bool1 = " + bool1 + ", bool2 = " + bool2);
        System.out.println("bool1 && bool2 (AND): " + (bool1 && bool2));
        System.out.println("bool1 || bool2 (OR): " + (bool1 || bool2));
        System.out.println("!bool1 (NOT): " + (!bool1));
        System.out.println("!bool2 (NOT): " + (!bool2));
       
        System.out.println("\n=== Unary Operators ===");
        int num = 5;
        System.out.println("Initial num = " + num);
        System.out.println("Pre-increment (++num): " + (++num));
        System.out.println("Post-increment (num++): " + (num++));
        System.out.println("After post-increment, num = " + num);
        System.out.println("Pre-decrement (--num): " + (--num));
        System.out.println("Post-decrement (num--): " + (num--));
        System.out.println("After post-decrement, num = " + num);
        System.out.println("Unary minus (-num): " + (-num));
        System.out.println("Unary plus (+num): " + (+num));
       
        System.out.println("\n=== Ternary Operator ===");
        int age = 18;
        String result = (age >= 18) ? "Adult" : "Minor";
        System.out.println("Age = " + age);
        System.out.println("Status: " + result);
        
        System.out.println("\n=== instanceof Operator ===");
        String str = "Hello";
        Object obj = new Operators();
        System.out.println("str instanceof String: " + (str instanceof String));
        System.out.println("str instanceof Object: " + (str instanceof Object));
        System.out.println("obj instanceof String: " + (obj instanceof String));
        System.out.println("obj instanceof Operators: " + (obj instanceof Operators));
        System.out.println("obj instanceof Object: " + (obj instanceof Object));
    }
}