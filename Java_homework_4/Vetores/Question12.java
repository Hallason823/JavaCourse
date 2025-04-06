import java.util.Scanner;

public class Question12 {
    public static final int ARR_SIZE = 5;

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
        System.out.printf("%.2f}.", arr[arr.length-1]);
    }

    public static double[] getMinMaxAverValue(double[] arr) {
        double[] min_max_aver_values = {Double.MAX_VALUE, Double.MIN_VALUE, 0.0};
        for (int i = 0; i < arr.length; i++) {
            if (min_max_aver_values[0] > arr[i]) min_max_aver_values[0] = arr[i];
            if (min_max_aver_values[1] < arr[i]) min_max_aver_values[1] = arr[i];
            min_max_aver_values[2] += arr[i];
        }
        min_max_aver_values[2]*=(1.0/arr.length);
        return min_max_aver_values;
    }

    public static void printMinMaxAverValues(double[] min_max_values) {
        String[] messages = {"Min: ", "Max: ", "Aver: "};
        for (int i = 0; i < messages.length; i++) {
            System.out.printf(messages[i] + "%.2f\n", min_max_values[i]);
        }
    }
    
    public static void main(String[] args) {
        double[] arr = new double[ARR_SIZE];
        getArray(arr);
        double[] min_max_aver_values = getMinMaxAverValue(arr);
        System.out.println("\nInput: ");
        printArray(arr);
        System.out.println("\n\nOutput: ");
        printMinMaxAverValues(min_max_aver_values);
    }
}