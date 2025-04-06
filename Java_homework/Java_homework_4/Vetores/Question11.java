public class Question11 {
    public static final int ARR_SIZE = 10;
    public static final double START_VALUE = -10.0;
    public static final double INCREMENT = 2.5;

    public static void fillArrayByIncrement(double[] arr, double start_value, double increment) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = start_value + ((double) i) * increment;
        }
    }

    public static int amountNegativeNumbers(double[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0.0) count++;
        }
        return count;
    }

    public static double getSumPositiveNumbers(double[] arr) {
        double sum = 0.0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0.0) sum += arr[i];
        }
        return sum;
    }

    public static void printResults(int negative_count, double positive_sum) {
        System.out.printf("Output: Negative amount -> %d | Positive sum -> %.2f", negative_count, positive_sum);
    }

    public static void main(String[] args) {
        double[] arr = new double[ARR_SIZE];
        int negative_count;
        double positive_sum;
        fillArrayByIncrement(arr, START_VALUE, INCREMENT);
        negative_count = amountNegativeNumbers(arr);
        positive_sum = getSumPositiveNumbers(arr);
        printResults(negative_count, positive_sum);
    }   
}