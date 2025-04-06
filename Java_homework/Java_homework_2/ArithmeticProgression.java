import java.util.Scanner;

public class ArithmeticProgression {

    public static Scanner input = new Scanner(System.in);

    public static int[] getAPParameters() {
        int parameters_number = 3;
        int[] ap_parameters = new int[parameters_number];
        String[] output_text = {"Type the AP initial term: ", "Type the AP ratio: ", "Type the terms number to be shown: "};
        for (int i = 0; i < parameters_number; i++) {
            System.out.print(output_text[i]);
            ap_parameters[i] = input.nextInt();
        }
        return ap_parameters;
    }

    public static int[] getAP(int[] ap_parameters) {
        int[] pa_terms = new int[ap_parameters[2]];
        for (int i = 0; i < ap_parameters[2]; i++) {
            pa_terms[i] = ap_parameters[0]+i*ap_parameters[1];
        }
        return pa_terms;
    }

    public static void printAP(int[] pa_terms) {
        System.out.print("The result is: ");
        for (int i = 0; i < (pa_terms.length-1); i++) {
            System.out.print(pa_terms[i] + ", ");
        }
        System.out.print(pa_terms[pa_terms.length-1] + ".");
    }

    public static void main(String[] args) {
        int [] pa_parameters = getAPParameters();
        int [] pa_terms = getAP(pa_parameters);
        printAP(pa_terms);
    }
}