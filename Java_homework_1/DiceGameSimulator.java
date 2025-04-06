package Java_homework;
import java.util.Random;
import java.util.Scanner;


public class DiceGameSimulator {

public static Scanner input = new Scanner(System.in);

public static Random generateRandomNumber = new Random();

public static int[] getResult(int[] num) {
    int[] individual_score = new int[2];
    System.out.print("The player 1: " + num[0] + " - The player 2 : " + num[1]);
    if (num[0] > num[1]) {
        System.out.println(" - The first player won.");
        individual_score = new int[]{1, 0};
    }
    else if (num[0] == num[1]) {
        System.out.println(" - The players tied.");
        individual_score = new int[]{1, 1};
    }
    else {
        System.out.println(" - The second player won.");
        individual_score = new int[]{0, 1};
    }
    return individual_score;
}

public static void main (String[] args) {
    int num_iter = 10, players_num = 2;
    int min_face_value = 1, max_face_value = 6;
    int[] luck_num = new int[players_num], result = new int[players_num], score = {0, 0};
    if (args.length > 0 && (args[0].equalsIgnoreCase("y"))) {
        System.out.print("Enter the total number of matches: ");
        num_iter = input.nextInt();
    }
    for (int i = 1; i <= num_iter; i++) {
        for (int j = 0; j < players_num; j++) {
            luck_num[j] = generateRandomNumber.nextInt(max_face_value)+min_face_value;
        }
        System.out.println("\nThe Game " + i + ":");
        result = getResult(luck_num);
        for (int j = 0; j < players_num; j++) {
            score[j] += result[j];
        }
    }
    System.out.print("\nThe end of the Game: ");
    result = getResult(score);
    System.out.print("Congratulations!");
}
}