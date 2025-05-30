public class SubsequenceFibonacci {

    public static void advanceSubsequenceFibonacci(int[] subsequence_fib) {
        int aux_var;
        aux_var = subsequence_fib[0];
        subsequence_fib[0] = subsequence_fib[1];
        subsequence_fib[1] += aux_var;
    }

    public static boolean isSubsequenceFibonacci(int[] arr) {
        boolean is_subsequence_fibonacci = true;
        int[] subsequence_fib = {1, 1};
        int count = 1;
        if (arr.length == 0) {
            return is_subsequence_fibonacci;
        }
        while (subsequence_fib[0] < arr[0]) {
            advanceSubsequenceFibonacci(subsequence_fib);
            if (subsequence_fib[0] > arr[0]) {
                is_subsequence_fibonacci = false;
            } 
        }
        while (is_subsequence_fibonacci && count < arr.length) {
            if (count == 1 && arr[0] == 1 && arr[1] == 2) {
                advanceSubsequenceFibonacci(subsequence_fib);
            }
            if (subsequence_fib[1] != arr[count]) {
                is_subsequence_fibonacci = false;
            }
            advanceSubsequenceFibonacci(subsequence_fib);
            count += 1;
        }
        return is_subsequence_fibonacci;
    }

    public static void printArray(String message, int[] arr) {
        System.out.print(message);
        for (int i=0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void printClassificationOfMultiplesSubsequences(int[][] subsequences) {
        for (int i = 0; i < subsequences.length; i++) {
            printArray("\nArray: ", subsequences[i]);
            System.out.printf("\nIs it a subsequence of Fibonacci? %b", isSubsequenceFibonacci(subsequences[i]));
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        int[][] subsequences_unit_length = {{1}, {2}, {3}, {32}, {5}, {9}, {11}, {13}, {34}};
        int[][] subsequences_non_unit_length = {{1, 1, 2, 3}, {8, 12, 20, 32}, {7, 9, 10, 15},
                                                {1, 2, 3, 5}, {1, 1, 5, 6}, {34, 23, 23, 11},
                                                {8, 13, 21, 34}, {2, 3, 5, 8}, {3, 5, 8, 13}};
        printClassificationOfMultiplesSubsequences(new int[][]{{}});
        printClassificationOfMultiplesSubsequences(subsequences_unit_length);
        printClassificationOfMultiplesSubsequences(subsequences_non_unit_length);
    }
}