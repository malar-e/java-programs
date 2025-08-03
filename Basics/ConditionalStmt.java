import java.util.Scanner;

public class ConditionalStmt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== if....else ===");
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        if (num < 0) {
            System.out.println("Numbet is negative");
        } else if (num > 0) {
            System.out.println("Number is positive");
        } else {
            System.out.println("Number is 0");
        }

        System.out.println("\n=== switch ===");
        System.out.print("Enter your grade: ");
        char grade = sc.next().charAt(0);
        switch (grade) {
            case 'O':
            case 'A':
            case 'B':
            case 'C':
                System.out.println("Pass");
                break;
            case 'U':
                System.out.println("Fail");
                break;
            default:
                System.out.println("Invalid grade");
        }
    }
}