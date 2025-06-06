import java.util.Scanner;

public class ManagerProducts {

    public static Scanner input = new Scanner(System.in);

    public static void readProduct(Product p) {
      System.out.print("Type the name: ");
      p.name = input.nextLine();
      System.out.print("Type the description: ");
      p.description = input.nextLine();
      System.out.print("Type the unit price: ");
      p.unitPrice = input.nextDouble();
      System.out.print("Type the quantity in stock: ");
      p.quantityInStock = input.nextInt();
      input.nextLine();
    }

    public static void printProduct(Product p) {
      System.out.printf("{TITLE: %s,\nDESCRIPTION: %s,\nUNIT PRICE: %.2f,\nQUANTITY IN STOCK: %d}\n",
                        p.name, p.description, p.unitPrice, p.quantityInStock);
    }
    public static void main(String[] args) {
      Product[] products = {new Product(), new Product()};
      for (int i = 0; i < products.length; i++) {
        System.out.printf("-------ENTERING PRODUCT DATA %d-------\n", i+1);
        readProduct(products[i]);
      }
      System.out.println("-------PRINTING-------\n");
      for (int i = 0; i < products.length; i++) {
        printProduct(products[i]);
      }
    }
}