import java.util.Scanner;

public class Question16 {
    public static final int ARR_SIZE = 10;

    public static Scanner input = new Scanner(System.in);

    public static void getArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Type the element in the position %d of the array: ", i);
            arr[i] = input.nextDouble();
        }
    }

    public static int getUserInput() {
        int user_option = -1;
        while (user_option != 0 && user_option != 1 && user_option != 2) {
            System.out.printf("\nType (0) Exit Program (1) Show the Array in the direct way (2) Show the array in the reverse: ");
            user_option = input.nextInt();
            if (user_option != 0 && user_option != 1 && user_option != 2) System.out.printf("\nInvalidy input. Try again, please!\n");
        }
        return user_option;
    }

    public static void printArray(double[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length-1; i++) {
            System.out.printf("%.2f, ", arr[i]);
        }
        System.out.printf("%.2f}.", arr[arr.length-1]);
    }
    
    public static void getReverseArray(double[] arr) {
        int reverse_limit = arr.length/2;
        double aux;
        for (int i = 0; i < reverse_limit; i++) {
            aux = arr[i];
            arr[i] = arr[arr.length-(i+1)];
            arr[arr.length-(i+1)] = aux;
        }
    }
    public static void main(String[] args) {
        double[] arr = new double[ARR_SIZE];
        getArray(arr);
        int user_answer = getUserInput();

        if (user_answer == 0) {
            System.exit(0);
        } else if (user_answer == 1) {
            System.out.println("\nOutput: ");
            printArray(arr);
        } else {
            System.out.println("\nOutput: ");
            getReverseArray(arr);
            printArray(arr);
        }
   }
}