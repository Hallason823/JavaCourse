import java.util.Scanner;

public class Question13 {
    public static final int ARR_SIZE = 10;

    public static Scanner input = new Scanner(System.in);

    public static void getArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Type the element in the position %d of the array: ", i);
            arr[i] = input.nextDouble();
        }
    }

    public static void printArray(double[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length-1; i++) {
            System.out.printf("%.2f, ", arr[i]);
        }
        System.out.print(arr[arr.length-1] +"}.");
    }

    public static double[] getMinMaxValueAndIdx(double[] arr) {
        double[] min_max_values_and_idx = {Double.MAX_VALUE, -1, Double.MIN_VALUE, -1};
        for (int i = 0; i < arr.length; i++) {
            if (min_max_values_and_idx[0] > arr[i]) {
                min_max_values_and_idx[0] = arr[i];
                min_max_values_and_idx[1] = i;
            }   
            if (min_max_values_and_idx[2] < arr[i]) {
                min_max_values_and_idx[2] = arr[i];
                min_max_values_and_idx[3] = i;
            }
        }
        return min_max_values_and_idx;
    }

    public static void printMinMaxValuesAndIdx(double[] min_max_values_and_idx) {
        String[] messages = {"Min Value: ", " | Min Idx: ", "Max Value: ", " | Max Idx: "};
        for (int i = 0; i < messages.length; i++) {
           if (i%2 == 0) {
                System.out.printf(messages[i] + "%.2f", min_max_values_and_idx[i]);
           } else {
                System.out.printf(messages[i] + "%d\n", (int) min_max_values_and_idx[i]);
           }
        }
    }
    
    public static void main(String[] args) {
        double[] arr = new double[ARR_SIZE];
        getArray(arr);
        double[] min_max_values_and_idx = getMinMaxValueAndIdx(arr);
        System.out.println("\nInput: ");
        printArray(arr);
        System.out.println("\n\nOutput: ");
        printMinMaxValuesAndIdx(min_max_values_and_idx);
    }
}