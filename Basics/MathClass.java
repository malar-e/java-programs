public class MathClass {
    public static void main(String[] args) {
        long startTime, endTime;
        double time;

        startTime = System.currentTimeMillis();

        double width = 42.0d, height = 17.0d;
        double hypotenuse = Math.hypot(width, height); // Calculates sqrt(width² + height²)
        System.out.println("A triangle with sides 42 and 17 has hypotenuse: " + hypotenuse);

        System.out.println("Absolute value of -2 is: " + Math.abs(-2));

        System.out.println("Mathematically, sin(x)² + cos(x)² - 1 should be 0.");
        int x = 1;
        System.out.println("x = " + x);
        System.out.println("sin(1)² + cos(1)² - 1 = " +
                (Math.sin(x) * Math.sin(x) + Math.cos(x) * Math.cos(x) - 1));

        System.out.println("Random number between 0.0 and 1.0: " + Math.random());
        System.out.println("tan(1) = " + Math.tan(1));
        System.out.println("asin(0.5) = " + Math.asin(0.5)); // arcsine
        System.out.println("acos(0.5) = " + Math.acos(0.5));
        System.out.println("atan(1.5) = " + Math.atan(1.5));
        System.out.println("sinh(1.5) = " + Math.sinh(1.5)); // (e^x - e^(-x)) / 2
        System.out.println("cosh(1.5) = " + Math.cosh(1.5)); // (e^x + e^(-x)) / 2
        System.out.println("tanh(1.5) = " + Math.tanh(1.5)); // hyperbolic tangent - sinh(x)/cosh(x)

        System.out.println("e^x = " + Math.exp(x));
        System.out.println("e^x - 1 = " + Math.expm1(x));
        System.out.println("ln(x) = " + Math.log(x));
        System.out.println("log₁₀(x) = " + Math.log10(x));
        System.out.println("ln(x + 1) = " + Math.log1p(x));

        double y = 3.56;
        System.out.println("y = " + y);
        System.out.println("Floor of y = " + Math.floor(y));
        System.out.println("Ceil of y = " + Math.ceil(y));
        System.out.println("Round of y = " + Math.round(y));
        System.out.println("Cube root of y = " + Math.cbrt(y));
        System.out.println("y² = " + Math.pow(y, 2));

        System.out.println("Sum of x and y = " + Math.addExact(x, (int)y));
        System.out.println("Difference of x and y = " + Math.subtractExact(x, (int)y));
        System.out.println("Product of x and y = " + Math.multiplyExact(x, (int)y));
        System.out.println("Copy sign from y to -2.9 = " + Math.copySign(-2.9, y));

        System.out.println("Decrement of y = " + Math.decrementExact((int)y));
        System.out.println("Increment of y = " + Math.incrementExact((int)y));

        System.out.println("Floor division of x / y = " + Math.floorDiv(x, (int)y));
        System.out.println("Floor modulus of x % y = " + Math.floorMod(x, (int)y));

        System.out.println("Exponent part of 10 (in 2^exp) = " + Math.getExponent(10));
        System.out.println("Negation of x = " + Math.negateExact(x));

        System.out.println("Next floating-point after x toward y = " + Math.nextAfter(x, y));
        System.out.println("Next floating-point below y = " + Math.nextDown(y));
        System.out.println("Next floating-point above y = " + Math.nextUp(y));

        System.out.println("Math.PI = " + Math.PI);
        System.out.println("Math.E = " + Math.E);

        System.out.println("Square root of x = " + Math.sqrt(x));
        System.out.println("Rint (rounded to even) of y = " + Math.rint(y)); // rounds a number to the nearest integer. If there are two integers that are equally close to the number then the even integer will be returned. 
        System.out.println("scalb(x, y) = " + Math.scalb(x, (int)y)); // x * 2^y

        System.out.println("Sign of -5 = " + Math.signum(-5));
        System.out.println("Degrees from radians y = " + Math.toDegrees(y));
        System.out.println("Radians from degrees 90 = " + Math.toRadians(90));
        System.out.println("toIntExact(5L) = " + Math.toIntExact(5L));

        endTime = System.currentTimeMillis();
        time = (endTime - startTime) / 1000.0;
        System.out.println("Run time of this program is " + time + " seconds.");
    }
}
