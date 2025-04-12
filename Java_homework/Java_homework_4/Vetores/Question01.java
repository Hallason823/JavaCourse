public class Question01 {
    public static int getSumSelectedIdxOfArray(int[] arr, int[] idx) {
        int sum = 0;
        for (int i = 0; i < idx.length; i++) {
            sum += arr[idx[i]];
        }
        return sum;

    }

    public static void printArray(int[] arr) {
        System.out.println("\nThe array is:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        //A) attributing
        int[] A = {1, 0, 5, -2, -5, 7};
        //B) sum of selected idx of A --> 0, 1, 5
        int[] idx_sum_A = {0, 1, 5};
        int sum_selected_idx_of_A = getSumSelectedIdxOfArray(A, idx_sum_A);
        System.out.println("The sum of selected idx of A is: " + sum_selected_idx_of_A);
        //C) change the value of A in the position 4 by 100
        A[4] = 100;
        //D) print Array by row
        printArray(A);
    }
}