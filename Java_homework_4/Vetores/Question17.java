import java.util.Scanner;

public class Question17 {    
    public static final int ARR_SIZE = 10;
    public static final double CHANGED_NUM = 0.0;

    public static Scanner input = new Scanner(System.in);

    public static void getArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Type the element in the position %d of the array: ", i);
            arr[i] = input.nextDouble();
        }
    }

    public static void changeNegativesElementByNumber(double[] arr, double changed_num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) arr[i] = changed_num;
        }
    }

    public static void printArray(String message, double[] arr) {
        System.out.print(message + "{");
        for (int i = 0; i < arr.length-1; i++) {
            System.out.printf("%.2f, ", arr[i]);
        }
        System.out.printf("%.2f}.", arr[arr.length-1]);
    }

    public static void main(String[] args) {
        double[] arr = new double[ARR_SIZE];
        getArray(arr);
        printArray("\nInput: ", arr);
        changeNegativesElementByNumber(arr, CHANGED_NUM);
        printArray("\nOutput: ", arr);
    }
}