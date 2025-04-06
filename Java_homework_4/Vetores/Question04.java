import java.util.Scanner;

public class Question04 {
    public static final int ARR_SIZE = 8;
    public static final int POS_ARR_SIZE = 2;

    public static Scanner input = new Scanner(System.in);

    public static void getArray(String message, int[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.printf( message, i);
            arr[i] = input.nextInt();
        }
    }

    public static void printSumSelectedIdxOfArray(int[] arr, int[] pos) {
        int sum = 0;
        for (int i = 0; i < pos.length; i++) {
            sum += arr[pos[i]];
        }
        System.out.println("\nThe sum is: " + sum);
    }

    public static void main(String[] args) {
        int[] arr = new int[ARR_SIZE];
        int[] pos = new int[POS_ARR_SIZE];
        getArray("Type the element in the position %d of the array: ", arr);
        getArray("Type the element in the position %d of the pos array: ", pos);
        printSumSelectedIdxOfArray(arr, pos);
    }
}