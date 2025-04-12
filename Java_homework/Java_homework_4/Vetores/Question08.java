import java.util.Scanner;

public class Question08 {
    public static final int ARR_SIZE = 6;

    public static Scanner input = new Scanner(System.in);

    public static void getArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Type the element in the position %d of the array: ", i);
            arr[i] = input.nextInt();
        }
    }

    public static void getReverseArray(int[] arr) {
        int aux, reverse_limit = arr.length/2;
        for (int i = 0; i < reverse_limit; i++) {
            aux = arr[i];
            arr[i] = arr[arr.length-(i+1)];
            arr[arr.length-(i+1)] = aux;
        }
    }

    public static void printArray(String message, int[] arr) {
        System.out.printf(message + "{");
        for (int i = 0; i < arr.length-1; i++) {
            System.out.printf("%d, ", arr[i]);
        }
        System.out.printf("%d}.", arr[arr.length-1]);
    }
    public static void main(String[] args) {
        int[] arr = new int[ARR_SIZE];
        getArray(arr);
        printArray("\nInput: ", arr);
        getReverseArray(arr);
        printArray("\nOutput: ", arr);
    }
}