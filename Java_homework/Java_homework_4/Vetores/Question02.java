import java.util.Scanner;

public class Question02 {
    public static final int ARR_SIZE = 6;

    public static Scanner input = new Scanner(System.in);

    public static void getArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Type the element in the position %d of the array: ", i);
            arr[i] = input.nextInt();
        }
    }

    public static void printArray(int[] arr) {
        System.out.print("\nThe array is: {");
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length-1] +"}.");
    }

    public static void main(String[] args) {
        int[] arr = new int[ARR_SIZE];
        getArray(arr);
        printArray(arr);
    }
}