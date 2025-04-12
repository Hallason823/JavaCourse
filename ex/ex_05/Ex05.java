package ex_05;
import java.util.Random;

public class Ex05 {
    public static Random generateRandom = new Random();

    public static void main (String[] args){
        int num_A;
        int num_B;
        int points_A = 0;
        int points_B = 0;

        for (int i = 0; i < 10; i++){
            num_A = generateRandom.nextInt(6)+1;
            num_B = generateRandom.nextInt(6)+1;
            System.out.println("Game " + (i+1) + ":");
            if (num_A > num_B) {
                System.out.println("A win!");
                points_A += 1;
            }
            else if (num_A == num_B) {
                System.out.println("A and B win!");
                points_A += 1;
                points_B += 1;
            }
            else {
                System.out.println("B win!");
                points_B += 1;
            }
        }

        System.out.println("The end of Game:");

        if (points_A > points_B) {
            System.out.println("A win!");
        }
        else if (points_A == points_B) {
            System.out.println("A and B win!");
        }
        else {
            System.out.println("B win!");
        }
    }
}
