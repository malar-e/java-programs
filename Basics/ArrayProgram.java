import java.util.Scanner;

public class ArrayProgram {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Single Dimensional Array ===");
        System.out.print("\nLength: ");
        int len = sc.nextInt();
        int[] arr= new int[len];
        System.out.println();
        for (int i=0; i<len ;i++){
            System.out.print("arr["+i+"]: ");
            arr[i] = sc.nextInt();
        }
        System.out.println();
        for (int i=0; i<len; i++){
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        float sum=0, avg;
        for (int value : arr) {
            sum += value;
        }
        avg = sum/len;
        System.out.println("\nSum: " + sum);
        System.out.println("Average: " + avg);

        System.out.println("\n=== Multi Dimensional Array ===\n");
        int[][] mdArray = {{23,45,3}, {4,5,34}, {8,98,2}};
        for (int[] array : mdArray) {
            for (int value : array) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }

        int lowestNumber = mdArray[0][0];
        for (int i=0; i<mdArray.length; i++) {
            for (int j=0; j<mdArray[i].length; j++) {
                if (mdArray[i][j]<lowestNumber) {
                    lowestNumber = mdArray[i][j];
                }
            }
        }
        System.out.println("\nLowest Number: " + lowestNumber);
    }
}