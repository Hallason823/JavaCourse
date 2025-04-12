import java.util.Scanner;

public class Question07 {
    public static final int ARR_SIZE = 10;

    public static Scanner input = new Scanner(System.in);

    public static void getArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Type the element in the position %d of the array: ", i);
            arr[i] = input.nextInt();
        }
    }

    public static void printArray(String message, int[] arr) {
        System.out.printf(message + "{");
        for (int i = 0; i < arr.length-1; i++) {
            System.out.printf("%d, ", arr[i]);
        }
        System.out.printf("%d}.", arr[arr.length-1]);
    }

    public static void printMaxValueAndIdx(int[] arr) {
        int idx = -1, max_value = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max_value < arr[i]) {
                idx = i;
                max_value = arr[i];
            }
        }
        System.out.printf("\n\nOutput: Pos Max Value -> %d | Max Value -> %d.", idx, max_value);
    }
    public static void main(String[] args) {
        int[] arr = new int[ARR_SIZE];
        getArray(arr);
        printArray("\nInput: ", arr);
        printMaxValueAndIdx(arr);
    }
}