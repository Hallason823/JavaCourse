import java.util.Scanner;

public class Exemplo04While {

    public static Scanner input = new Scanner(System.in);

    public static void main (String[] args) {
        int number_st, number_nd, qtd_int;
        System.out.print("Type an integer number: ");
        number_st = input.nextInt();
        System.out.print("Type an integer number bigger than " + number_st + ": ");
        number_nd = input.nextInt();
        while (number_nd <= number_st) {
            System.out.println("Error! Invalidy input");
            System.out.println("Type an integer number bigger than " + number_st + ": ");
            number_nd = input.nextInt();
        }
        qtd_int = number_nd - number_st + 1;
        System.out.println("There are " + qtd_int + " numbers between " + number_st + " and " + number_nd);
    }
}