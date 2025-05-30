import java.util.Random;

public class ReverseArray {
    
    public static final int ARR_SIZE = 30;
    public static final int ARR_MIN_VALUE = 3;
    public static final int ARR_MAX_VALUE = 20;
    public static final int AMOUNT_CHARACTERS_BY_ROW = 150;

    public static Random generateRandomNumber = new Random(5);

    public static void fillArrayRandomly(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = generateRandomNumber.nextInt((ARR_MAX_VALUE+1)-ARR_MIN_VALUE)+ARR_MIN_VALUE;
        }
    }

    public static int getAmountOfDigits(int num) {
        return (int) Math.log10(num)+1;
    }
    
    public static void printArray(String message, int[] arr) {
        System.out.print(message);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%"+getAmountOfDigits(ARR_MAX_VALUE)+"d ", arr[i]);
            if ((i+1)%(AMOUNT_CHARACTERS_BY_ROW/(getAmountOfDigits(ARR_MAX_VALUE)+1)) == 0) {
                System.out.println();
            }
        }
    }

    public static void reverseArray(int[] arr){
        int aux;
        for (int i = 0; i < arr.length/2; i++) {
            aux = arr[i];
            arr[i] = arr[(arr.length-1)-i];
            arr[(arr.length-1)-i] = aux;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[ARR_SIZE];
        fillArrayRandomly(arr);
        printArray("INPUT: ", arr);
        reverseArray(arr);
        printArray("\nOUTPUT: ", arr);
    }
}
