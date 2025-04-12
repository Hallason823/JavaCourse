import java.util.Scanner;
import java.util.ArrayList;

public class StorePromotion {

    public static Scanner input = new Scanner(System.in);

    public static double[] insertSingleData() {
        int parameters_number = 3;
        String[] output_text = {"Type the product category (1, 2 or 3): ", "Type the product price($): ",
        "Type the amount of this product: "};
        double[] single_data = new double[parameters_number];
        for (int i = 0; i < parameters_number; i++) {
            System.out.println(output_text[i]);
            single_data[i] = input.nextDouble();
        }
        return single_data;
    }

    public static ArrayList<double[]> getCustomerPurchase () {
        String customer_answer;
        ArrayList<double[]> purchase_data = new ArrayList<>();
        do {
            purchase_data.add(insertSingleData());
            System.out.println("Would you like to insert other products? (Type \"y\" to confirm)");
            customer_answer = input.next();
        } while (customer_answer.equalsIgnoreCase("y"));
        return purchase_data;
    }

    public static double[] getPriceChange (double[] single_purchase){
        double[] discounts_values_by_product_category = {0.1, 0.15, 0.08}, discounts_values_by_product_amount = {0.02, 0.05, 0.10}, 
        ref_amounts = {2.0, 10.0}, price_change = new double[2];
        double price_new_factor = 1.0;
        price_new_factor *= (1-discounts_values_by_product_category[(int) (single_purchase[0]-1)]);
        if (single_purchase[2] <= ref_amounts[0]){
            price_new_factor *= (1-discounts_values_by_product_amount[0]);
        }
        else if (single_purchase[2] <= ref_amounts[1]) {
            price_new_factor *= (1-discounts_values_by_product_amount[1]);
        }
        else {
            price_new_factor *= (1-discounts_values_by_product_amount[2]);
        }
        price_change[0] = single_purchase[1]*single_purchase[2];
        price_change[1] = price_new_factor*price_change[0];
        return price_change;
    }

    public static void printSingleProductInfo (int idx, double[] price_change) {
        double discount = price_change[0] - price_change[1];
        System.out.printf("\nThe products inserted of the index %d of value $%,.2f and out for only $%,.2f which means an economy of $%,.2f.",
         idx, price_change[0], price_change[1],  discount);
    }

    public static void printPurchaseAllInfo (double[] price_change_sum) {
        double total_discount = price_change_sum[0] - price_change_sum[1];
        System.out.printf("\n\nThe all purchase would be the value $%,.2f and out for only $%,.2f which means a total economy of $%,.2f.",
        price_change_sum[0],  price_change_sum[1],total_discount);
    }

    public static void getPurchaseData(ArrayList<double[]> purchase_data) {
        int product_dif_amount = purchase_data.size();
        double[] price_change = new double[2], price_change_sum = {0.0, 0.0};
        for (int i = 0; i < product_dif_amount; i++){
            price_change = getPriceChange(purchase_data.get(i));
            for (int j = 0; j < price_change.length; j++){
                price_change_sum[j] += price_change[j];
            }
            printSingleProductInfo(i+1, price_change);
        }
        printPurchaseAllInfo(price_change_sum);
    }

    public static void main (String[] args) {
        ArrayList<double[]> purchase_data = getCustomerPurchase();
        getPurchaseData(purchase_data);
    }
}