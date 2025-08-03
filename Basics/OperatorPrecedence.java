public class OperatorPrecedence {
    public static void main(String[] args){
        System.out.println("=== Operator Precedence ===");
        System.out.println("1. (), [], .");
        System.out.println("2. Unary: ++, --, +, -, !, ~, (type)");
        System.out.println("3. Arithmetic: *, /, %");
        System.out.println("4. Arithmetic: +, -");
        System.out.println("5. Shift: <<, >>, >>>");
        System.out.println("6. Relational: <, >, <=, >=, instanceof");
        System.out.println("7. Equality: ==, !=");
        System.out.println("8. Bitwise AND: &");
        System.out.println("9. Bitwise XOR: ^");
        System.out.println("10. Bitwise OR: |");
        System.out.println("11. Logical AND: &&");
        System.out.println("12. Logical OR: ||");
        System.out.println("13. Ternary: ?:");
        System.out.println("14. Assignment: =, +=, -=, *=, %=, &=, |=, ^=, >>=, <<=, >>>=");

        System.out.println("\n=== Associativity ===");
        System.out.println("Binary, Bitwise - left to right");
        System.out.println("Unary, Ternary, Assignment - right to left");
    }
}