package ex_05;
import java.util.Random;

public class Exemplo05 {

    public static Random generateRandom = new Random(5);
    public static void main (String[] args) {
        int sum = 0;
        for(int i = 0; i<10; i++) {
            //int random_number = (int) Math.floor(Math.random()*6) + 1;
            int random_number = generateRandom.nextInt(6)+1;
             System.out.println(random_number);
             sum += random_number;
        }

        System.out.println("Result: " + sum);

    }
}
