import java.util.Scanner;

public class Question05 {

    public static final int ARR_SIZE = 10;

    public static Scanner input = new Scanner(System.in);

    public static void getArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Type the element in the position %d of the array: ", i);
            arr[i] = input.nextInt();
        }
    }

    public static void printAmountEvenOfArray(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%2 == 0) {
                count += 1;
            }
        }
        System.out.println("\nThe amount of even numbers in the array is: " + count);
    }
    public static void main(String[] args) {
        int[] arr = new int[ARR_SIZE];
        getArray(arr);
        printAmountEvenOfArray(arr);
    }
}