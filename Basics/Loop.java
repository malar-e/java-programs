import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
        System.out.println("=== while loop ===");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int i;
        while ((i=input.nextInt())<=10) {
            System.out.println(i);
            System.out.print("Enter a number: ");
        }
        System.out.print("Loop ends");

        System.out.println("\n\n=== do/while loop ===");
        int j=10;
        do {
            System.out.println(j);
            j++;
        }
        while (j<10);

        int k=10;
        while (k<10){
            System.out.println(k);
            k++;
        }

        System.out.println("\n\n=== for loop ===");
        for (int l=0; l<=10; l+=2){
            System.out.print(l+"\t");
        }

        System.out.println("\n\n=== for loop with user input ==="); 
        int z;
        System.out.print("Enter a number: ");
        for (;(z=input.nextInt())<=10;){
            System.out.println(z);
            System.out.print("Enter a number: ");
        }
        System.out.print("Loop ends");

        System.out.println("\n\n=== for-each loop ===");
        int[] arr={1,2,3,4};
        for (int value : arr){
            System.out.print(value+"\t");
        }

        System.out.println("\n\n=== nested while loop ===");
        int a=1;
        while(a<=3) {
            int b=1;
            while(b<=3) {
                System.out.print(a + "*" + b + "=" + a*b  + "\t");
                b++;
            }
            System.out.println();
            a++;
        }

        System.out.println("\n\n=== nested for loop ===");
        for (int m=1; m<=3;m++){
            for(int n=1;n<=3;n++){
                System.out.print(m + "*" + n + "=" + m*n + "\t");
            }
            System.out.println();
        }

        System.out.println("\n\n=== break statement ===");
        int x=1;
        while(x<=10) {
            if(x==5) {
                break;
            }
            System.out.print(x+"\t");
            x++;
        }

        System.out.println("\n\n=== continue statement ===");
        int y=1;
        while(y<=10) {
            if(y==5) {
                y++;
                continue;
            }
            System.out.print(y+"\t");
            y++;
        }
    }
}