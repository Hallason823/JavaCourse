import java.util.Scanner;

public class Practice03 {
    
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        double mass, height, imc;
        System.out.println("Type your mass (kg): ");
        mass = input.nextDouble();
        System.out.println("Type your height (m): ");
        height = input.nextDouble();
        imc = mass/(height*height);
        if (imc < 18.5) {
            System.out.println("Underweight");
        } else if (imc < 25.0) {
            System.out.println("Normal");
        } else if (imc < 30.0) {
            System.out.println("Overweight");
        } else if (imc < 35.0) {
            System.out.println("Obesity I");
        } else if (imc < 40.0) {
            System.out.println("Obesity II");
        } else {
            System.out.println("Obesity III");
        }
    }
}