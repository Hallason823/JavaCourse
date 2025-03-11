import java.util.Scanner;

public class Primos {

    public static Scanner input = new Scanner(System.in);

    public static int getInputNumber () {
        int num;
        do {
            System.out.print("Type a non negative integer number: ");
            num = input.nextInt();
        } while (num < 0);
        return num;
    }

    public static boolean isPrimeStartTwo (int num){
        boolean is_prime = true;
        if (num > 2){
            int count = 2, limit_check = (int) Math.ceil(Math.sqrt(num));
            while (is_prime == true && count <= limit_check){
                if (num%count == 0) {
                    is_prime = false;
                }
                ++count;
            }
        }
        return is_prime;
    }

    public static void main (String[] args) {
        int num = getInputNumber();
        boolean result = num < 2 ? false : isPrimeStartTwo(num);
        System.out.printf("The number %d is Prime? %b", num, result);
        System.out.println();
    }
}