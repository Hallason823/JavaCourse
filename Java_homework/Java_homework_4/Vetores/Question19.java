import java.util.Scanner;

class Question19 {
    public static final int ARR_SIZE = 50;
    public static final int PRODUCT_FACTOR = 5;

    public static Scanner input = new Scanner(System.in);

    public static void fillArrayWithExpression(int[] arr, int product_factor) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (i+product_factor*i)%(i+1);
        }
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
        fillArrayWithExpression(arr, PRODUCT_FACTOR);
        printArray("\nOutput: ", arr);    
    }
}