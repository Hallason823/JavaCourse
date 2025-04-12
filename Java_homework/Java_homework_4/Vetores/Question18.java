import java.util.Scanner;

public class Question18 {
    public static final int ARR_SIZE = 10;

    public static Scanner input = new Scanner(System.in);

    public static void getArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Type the element in the position %d of the array: ", i);
            arr[i] = input.nextInt();
        }
    }

    public static int getNumber() {
        System.out.println("\n\nType an integer number: ");
        return input.nextInt();
    }

    public static void printAmountMultiplesOfNumber(int[] arr, int num) {
        int count = 0;
        System.out.print("\nThe multiples of the inserted number are: ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%num == 0) {
                System.out.print(arr[i] + " ");
                count++;
            } 
        }
        System.out.print("\nThe total is " + count);
    }

    public static void printArray(String message, int[] arr) {
        System.out.print(message + "{");
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length-1] + "}.");
    }

    public static void main(String[] args) {
        int[] arr = new int[ARR_SIZE];
        getArray(arr);
        printArray("\nInput: ", arr);
        printAmountMultiplesOfNumber(arr, getNumber());
    }
}