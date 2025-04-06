import java.util.Scanner;

public class OutstandingBalance {

    public static Scanner input = new Scanner(System.in);

    public static double[] getOBParameters() {
        int ob_parameters_number = 4;
        double[] ob_parameters = new double[ob_parameters_number];
        String[] output_text = {"Type the account value ($): ", "Type the penalty value ($): ",
        "Type the interest per month (e.g., 0.1 = 10%): ", "Type the number of days the account is overdue: "};
        for (int i = 0 ; i < ob_parameters_number; i++) {
            System.out.print(output_text[i]);
            ob_parameters[i] = input.nextDouble();
        }
        return ob_parameters;
    }

    public static double getAmountToPay(double[] ob_parameters) {
        int days_by_month = 30;
        return ob_parameters[1]+ob_parameters[0]*(1+ob_parameters[2]*(Math.ceil(ob_parameters[3])/days_by_month));
    }

    public static void printResult(int days_max_number, double[] ob_parameters) {
        if (Math.ceil(ob_parameters[3]) < days_max_number){
            System.out.printf("\nThe amount to pay is $%,.2f.", getAmountToPay(ob_parameters));
        }
        else {
            System.out.print("\nError! The bill is due in at least 45 days.");
        }
    }

    public static void main(String[] args) {
        int days_max_number = 45;
        double[] ob_parameters = getOBParameters();
        printResult(days_max_number, ob_parameters);
    }
}