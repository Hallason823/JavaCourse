package ex_21_02;
import java.util.Scanner;

public class ExemploTeste {

    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int num;
        System.out.print("Type an integer number: ");
        num = input.nextInt();
        System.out.println("You typed the number: " + num);
        if (num < 0) {
            System.out.println("The number is negative.");
        } else if (num == 0){
                System.out.println("The number is neutral.");
        } else {
            System.out.println("The number is positive.");
        }
    }
}