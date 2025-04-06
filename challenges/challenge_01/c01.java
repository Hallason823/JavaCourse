package challenges.challenge_01;
import java.util.Scanner;

public class c01 {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
      System.out.println("Type the list of numbers: ");
      String numbers = input.nextLine();
      String[] split_numbers = numbers.split(" ");
      int min = Integer.parseInt(split_numbers[0]), max = Integer.parseInt(split_numbers[0]);
      int split_numbers_length = split_numbers.length;
      for (int i = 1; i < split_numbers_length; i++){
        if (min > Integer.parseInt(split_numbers[i])){
          min = Integer.parseInt(split_numbers[i]);
        }
        if (max < Integer.parseInt(split_numbers[i])){
          max = Integer.parseInt(split_numbers[i]);
        }    
      }
      String result = max + " " + min;
      System.out.println(result);
    }
  }