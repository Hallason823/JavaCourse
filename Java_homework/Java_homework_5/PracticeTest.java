import java.util.Scanner;

public class PracticeTest {

    public static final int ARR_SIZE = 10;
    public static final int FILLED_ARR_SIZE = 5;

    public static Scanner input = new Scanner(System.in);

    public static void fillArray(int[] arr, int length_n) {
        for (int i=0; i < length_n; i++){
            System.out.printf("Type the element %d of the array: ", i);
            arr[i] = input.nextInt();
        }
    }

    public static void printArray(int[] arr, int length_n) {
        for (int i=0; i < length_n; i++) {
            System.out.printf("\nThe element %d of the array is %d.", i, arr[i]);
        }
    }

    public static void bubbleSort(int[] arr, int length_n) {
       int end = length_n-2, position = 0;
       boolean changed = true;
       int aux;
       while(changed) {
        changed = false;
        for (int i = 0; i <= end; i++) {
            if (arr[i] > arr[i+1]) {
                aux = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = aux;
                position = i;
                changed = true;
            }
        }
        end = position-1;
       }

    }

    public static void printLargestOdd(int[] arr, int length_n) {
        boolean find_odd = false;
        int largest_odd = 0;
        String message;
        for (int i = 0; i < length_n; i++) {
            if (arr[i]%2 != 0 && find_odd == false) {
                find_odd = true;
                largest_odd = arr[i];
            }
            else if (arr[i]%2 != 0 && largest_odd < arr[i]) {
                largest_odd = arr[i];
            }
        }
        message = (find_odd) ? "\nThe largest odd numbers is "+largest_odd+"." : "\nThere is not any odd number in the array.";
        System.out.println(message);
    }

    public static void fillFreeSpacesArrays(int[] odd_nums, int[] even_nums, int[] busy_spaces) {
       int min_start = (busy_spaces[0] < busy_spaces[1]) ? busy_spaces[0] : busy_spaces[1];
       for (int i = min_start; i < odd_nums.length; i++) {
            if (i >= busy_spaces[0]) odd_nums[i] = -1;
            if (i >= busy_spaces[1]) even_nums[i] = -1;
       }
    }

    public static void getOddAndEvenNumbersInTheArray(int[] arr, int length_n, int[] odd_nums, int[] even_nums) {
        int[] busy_spaces = {0, 0};
        for (int i = 0; i < length_n; i++) {
            if (arr[i]%2 != 0) {
                odd_nums[busy_spaces[0]] = arr[i];
                busy_spaces[0] += 1;
            }
            else {
                even_nums[busy_spaces[1]] = arr[i];
                busy_spaces[1] += 1; 
            }
        }
        fillFreeSpacesArrays(odd_nums, even_nums, busy_spaces);
    }

    public static void main(String[] args) {
        int[] arr = new int[ARR_SIZE], odd_arr = new int[ARR_SIZE], even_arr = new int[ARR_SIZE];
        fillArray(arr, FILLED_ARR_SIZE);   
        System.out.println("\nINPUT ARRAY: ");
        printArray(arr, FILLED_ARR_SIZE);
        bubbleSort(arr, FILLED_ARR_SIZE);
        System.out.println("\n\nSORTED ARRAY: ");
        printArray(arr, FILLED_ARR_SIZE);
        System.out.println("\n\nLARGEST ODD: ");
        printLargestOdd(arr, FILLED_ARR_SIZE);
        getOddAndEvenNumbersInTheArray(arr, FILLED_ARR_SIZE, odd_arr, even_arr);
        System.out.println("\nODD NUMBERS: ");
        printArray(odd_arr, ARR_SIZE);
        System.out.println("\n\nEVEN NUMBERS: ");
        printArray(even_arr, ARR_SIZE);
    }
}