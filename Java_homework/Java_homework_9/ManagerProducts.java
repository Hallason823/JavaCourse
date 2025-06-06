import java.util.Scanner;

public class ManagerProducts {

    public static final int MAX_AMOUNT_PRODUCTS = 100;

    public static Scanner input = new Scanner(System.in);

    public static void readProduct(Product product) {
        System.out.println("\nType the name: ");
        product.name = input.nextLine();
        System.out.println("Type the category: ");
        product.category = input.nextLine();
        System.out.println("Type the description: ");
        product.description = input.nextLine();
        System.out.println("Type the quantity minimum: ");
        product.quantityMin = input.nextInt();
        System.out.println("Type the quantity in stock: ");
        product.quantityInStock = input.nextInt();
        System.out.println("Type the unity price: ");
        product.unitPrice = input.nextDouble();
        input.nextLine();
    }

    public static int addSingleProductInTheArray(Product[] products, int current_size) {
        if (current_size < products.length) {
            products[current_size] = new Product();
            readProduct(products[current_size]);
            System.out.println("\nPRODUCT INSERTED SUCCESSFULLY!");
            return current_size+1;
        }
        System.out.println("FAILED! PRODUCTS ARRAY IS FULL!");
        return current_size;
    }

    public static void printSingleProduct(Product product, int idx) {
        System.out.printf("\nPRODUCT %d:\n{NAME: %s,\nCATEGORY: %s,\nDESCRIPTION: %s,\nQUANTITY MIN: %d,\nQUANTITY IN STOCK: %d,\nUNITY PRICE: %.2f}\n",
                                  idx+1, product.name, product.category, product.description, product.quantityMin, product.quantityInStock, product.unitPrice);
    }

    public static void printSingleProductSpecialWay(Product product, int idx) {
        System.out.printf("\nPRODUCT %d -  %d - %.2f\n", idx+1, product.quantityInStock, product.unitPrice);
    }

    public static void printProducts(Product[] products, int current_size) {
        if (current_size > 0) {
            for (int i = 0; i < current_size; i++) {
                printSingleProduct(products[i], i);
            }
        }
        else {
            System.out.println("\nTHE ARRAY IS EMPTY!");
        }
    }

    public static int removeSingleProductInTheArray(Product[] products, int current_size) {
        if (current_size > 0){
            int idx;
            System.out.println("\nType the index of the product that you would like to remove: ");
            idx = input.nextInt();
            while (idx >= current_size) {
                System.out.println("\nInvalid index! Try again, please.\nType the index of the product that you would like to remove: ");
                idx = input.nextInt();
            }
            products[idx] = products[current_size-1];
            products[current_size-1] = new Product();
            System.out.println("\nPRODUCT DELETED SUCCESSFULLY!");
            input.nextLine();
            return current_size-1;
        }
        return current_size;
    }

    public static void filterProductsByCategory(Product[] products, int current_size) {
        String filted_category;
        boolean found_category = false;
        System.out.println("\nType a category to filter: ");
        filted_category = input.nextLine();
        for (int i = 0; i < current_size; i++) {
            if (products[i].category.toUpperCase().compareTo(filted_category.toUpperCase()) == 0) {
                printSingleProduct(products[i], i);
                found_category = true;
            }
        }
        if (!found_category) {
            System.out.println("\nNO PRODUCTS FOUND FOR THIS CATEGORY.");
        }
    }

    public static double filterProductsByCategorySpecialWay(Product[] products, String filted_category, int current_size) {
        boolean found_category = false;
        double subtotal_by_category = 0.0;
        for (int i = 0; i < current_size; i++) {
            if (products[i].category.toUpperCase().compareTo(filted_category.toUpperCase()) == 0) {
                printSingleProductSpecialWay(products[i], i);
                subtotal_by_category +=  (double) products[i].quantityInStock * products[i].unitPrice;
                found_category = true;
            }
        }
        if (!found_category) {
            System.out.println("\nNO PRODUCTS FOUND FOR THIS CATEGORY.");
        }
        System.out.printf("\nSUBTOTAL: %.2f\n", subtotal_by_category);
        return subtotal_by_category;
    }

    public static void bubbleSortByNameAndUnitPrice(Product[] products, int current_size) {
        int end = current_size-1, position = 0;
        boolean change_arr = true;
        Product key;
        while (change_arr) {
            change_arr = false;
            for (int i = 0; i < end; i++) {
                if (products[i].name.toUpperCase().compareTo(products[i+1].name.toUpperCase()) > 0 || 
                    products[i].name.toUpperCase().compareTo(products[i+1].name.toUpperCase()) == 0 &&
                    products[i].unitPrice > products[i+1].unitPrice) {
                        key = products[i+1];
                        products[i+1] = products[i];
                        products[i] = key;
                        change_arr = true;
                        position = i;
                }
            }
            end = position;
        }
    }

    public static void updateUnityPrice(Product[] products, int current_size) {
        int idx;
        if (current_size > 0 ) {
            System.out.println("\nType the index of the product that you would like to update the unity price: ");
            idx = input.nextInt();
            while (idx >= current_size) {
                System.out.println("\nInvalid index! Try again, please.\nType the index of the product that you would like to update the unity price: ");
                idx = input.nextInt();
            }
            System.out.println("\nType the new unity price: ");
            products[idx].unitPrice = input.nextDouble();
            System.out.println("\nPRICE UPDATED SUCESSFULLY!");
            input.nextLine();
        }
    }

    public static int getAllAvailableCategories(Product[] products, String[] all_categories,  int current_size) {
        int j, all_categories_size = 0;
        boolean exists;
        for (int i = 0; i < current_size; i++) {
            exists = false;
            j = 0;
            while (!exists && j < all_categories_size) {
                if (products[i].category.toUpperCase().compareTo(all_categories[j].toUpperCase()) == 0) {
                    exists = true;
                }
                j += 1;
            }
            if (!exists) {
                all_categories[all_categories_size] = products[i].category;
                all_categories_size += 1;
            }
        }
        return all_categories_size;
    }

    public static void printProductsSpecialWay(Product[] products, String[] all_categories, int current_size) {
        int all_categories_size;
        double total_sum = 0.0;
        if (current_size > 0 ) {
            all_categories_size = getAllAvailableCategories(products, all_categories, current_size);
            for (int i = 0; i < all_categories_size; i++) {
                System.out.println("\nCategory " + (i+1) + " " + all_categories[i]);
                total_sum += filterProductsByCategorySpecialWay(products, all_categories[i], current_size);
            }
            System.out.printf("\nTOTAL SUM: %.2f", total_sum);
        }
        else {
            System.out.println("\nTHE ARRAY IS EMPTY!");
        }
    }

    public static int runUserOption(Product[] products, String[] all_categories, int current_size, int selected_option) {
        switch (selected_option) {
            case 1:
                current_size = addSingleProductInTheArray(products, current_size);
                printProducts(products, current_size);
                break;
            case 2:
                printProducts(products, current_size);
                break;
            case 3:
                filterProductsByCategory(products, current_size);
                break;
            case 4:
                bubbleSortByNameAndUnitPrice(products, current_size);
                printProducts(products, current_size);
                break;
            case 5:
                current_size = removeSingleProductInTheArray(products, current_size);
                printProducts(products, current_size);
                break;
            case 6:
                updateUnityPrice(products, current_size);
                printProducts(products, current_size);
                break;
            case 7:
                printProductsSpecialWay(products, all_categories, current_size);
                break;
            default:
                System.out.println("\nInvalid option!");
        }
        return current_size;
    }

    public static void interactWithUser(Product[] products, String[] all_categories, int current_size) {
        String continue_process;
        int user_answer;
        System.out.println("Would you like to use this application for manager products? (Type y or Y to confirm)");
        continue_process = input.nextLine();
        while (continue_process.toUpperCase().compareTo("Y") == 0) {
            System.out.println("\nSelect an option: \n(1) Insert a single product;\n(2) Print all products;" + 
                               "\n(3) Filter by Category;\n(4) Sort by name and unit price;\n(5) Delete product;" + 
                               "\n(6) Update unit price of a single product;" +
                               "\n(7) Print all products and showing the total value by category.\n");
            user_answer = input.nextInt();
            input.nextLine();
            current_size = runUserOption(products, all_categories, current_size, user_answer);
            System.out.println("\nWould you like to continue? (Type y or Y to confirm)");
            continue_process = input.nextLine();
        }
    }
    public static void main(String[] args) {
        Product[] products = new Product[MAX_AMOUNT_PRODUCTS];
        String[] all_categories = new String[MAX_AMOUNT_PRODUCTS];
        int current_size = 0;
        interactWithUser(products, all_categories, current_size);
    }
}