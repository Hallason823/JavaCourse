import java.util.Scanner;

public class Question03 {
    public static final int ARR_SIZE = 10;

    public static Scanner input = new Scanner(System.in);

    public static void getArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Type the element in the position %d of the array: ", i);
            arr[i] = input.nextDouble();
        }
    }

    public static void getSquaredArrayElement(double[] arr, double[] squared_arr) {
        for (int i = 0; i < arr.length; i++) {
            squared_arr[i] = Math.pow(arr[i], 2.0);
        }
    }

    public static void printArray(String message, double[] arr) {
        System.out.printf(message + "{");
        for (int i = 0; i < arr.length-1; i++) {
            System.out.printf("%.2f, ", arr[i]);
        }
        System.out.printf("%.2f}.", arr[arr.length-1]);
    }

    public static void main(String[] args) {
        double[] arr = new double[ARR_SIZE], squared_arr = new double[ARR_SIZE];
        getArray(arr);
        printArray("\nInput: ", arr);
        getSquaredArrayElement(arr, squared_arr);
        printArray("\nOutput: ", squared_arr);
    }
}