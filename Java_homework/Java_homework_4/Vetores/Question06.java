import java.util.Scanner;

public class Question06 {
    
    public static final int ARR_SIZE = 10;

    public static Scanner input = new Scanner(System.in);

    public static void getArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Type the element in the position %d of the array: ", i);
            arr[i] = input.nextInt();
        }
    }

    public static int[] getMinMaxValue(int[] arr) {
        int[] min_max_values = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        for (int i = 0; i < arr.length; i++) {
            if (min_max_values[0] > arr[i]) min_max_values[0] = arr[i];
            if (min_max_values[1] < arr[i]) min_max_values[1] = arr[i];
        }
        return min_max_values;
    }

    public static void printMinMaxValues(int[] min_max_values) {
        String[] messages = {"Min: ", "Max: "};
        for (int i = 0; i < messages.length; i++) {
            System.out.println(messages[i] + min_max_values[i]);
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[ARR_SIZE];
        getArray(arr);
        int[] min_max_values = getMinMaxValue(arr);
        System.out.println("\nOutput: ");
        printMinMaxValues(min_max_values);
    }
}