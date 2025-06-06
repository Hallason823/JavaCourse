import java.util.Random;

public class RandomArray {

    public static final int ARR_SIZE = 200;
    public static final int ARR_MIN_VALUE = 1;
    public static final int ARR_MAX_VALUE = 20;
    public static final int AMOUNT_CHARACTERS_BY_ROW = 150;

    public static Random generateRandomNumber = new Random(5);

    public static void fillArrayRandomly(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = generateRandomNumber.nextInt(ARR_MAX_VALUE)+ARR_MIN_VALUE;
        }
    }

    public static int getAmountOfDigits(int num) {
        return (int) Math.log10(num)+1;
    }

    public static void printArray(int[] arr) {
        System.out.println("THE ARRAY IS:\n");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%"+getAmountOfDigits(ARR_MAX_VALUE)+"d ", arr[i]);
            if ((i+1)%(AMOUNT_CHARACTERS_BY_ROW/(getAmountOfDigits(ARR_MAX_VALUE)+1)) == 0) {
                System.out.println();
            }
        }
    }

    public static String getFormatedValueFreq(int max_counter_digits) {
        int max_arr_digits = getAmountOfDigits(ARR_MAX_VALUE);
        String formated_value = " ".repeat((int) Math.ceil((double) (12-max_arr_digits)/2)) + "%" + max_arr_digits + "d" + " ".repeat((12-max_arr_digits)/2) + "|";
        String formated_freq = " ".repeat((int) Math.ceil((double) (12-max_counter_digits)/2)) + "%" + max_counter_digits + "d" + " ".repeat((12-max_counter_digits)/2)+"\n";
        return formated_value+formated_freq;
    }

    public static void printFrequencyBySingleCounter(int[] arr) {
        int count;
        String formated_value_freq = getFormatedValueFreq(getAmountOfDigits(ARR_SIZE));
        System.out.println("\n   *VALUE   | *FREQUENCY \n" + "-".repeat(12)+"|"+"-".repeat(12));
        for (int i = ARR_MIN_VALUE; i <= ARR_MAX_VALUE; i++) {
            count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    count += 1;
                }
            }
            System.out.printf(formated_value_freq, i, count);
        }
        System.out.println("-".repeat(12)+"|"+"-".repeat(12));
    }

    public static void getFrequencyByArrayCounter(int[] arr, int[] counter) {
        for (int i = 0; i < arr.length; i++) {
            counter[arr[i]-ARR_MIN_VALUE] += 1;
        }
    }

    public static int getMaxValueOfArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void printArrayCounter(int[] counter) {
        String formated_value_freq = getFormatedValueFreq(getAmountOfDigits(getMaxValueOfArray(counter)));
        System.out.println("\n   *VALUE   | *FREQUENCY \n" + "-".repeat(12) + "|" + "-".repeat(12));
        for (int i = 0; i < counter.length; i++) {
            System.out.printf(formated_value_freq, ARR_MIN_VALUE+i, counter[i]);
        }
        System.out.println("-".repeat(12)+"|"+"-".repeat(12));
    }
    public static void main(String[] args) {
        int[] arr = new int[ARR_SIZE];
        int[] counter = new int[ARR_MAX_VALUE-ARR_MIN_VALUE+1];
        fillArrayRandomly(arr);
        printArray(arr);
        //Question 01
        System.out.println("\nQuestion 01 - by single counter");
        printFrequencyBySingleCounter(arr);
        //Question 02
        System.out.println("\nQuestion 02 - by array counter");
        getFrequencyByArrayCounter(arr, counter);
        printArrayCounter(counter);     
    } 
}