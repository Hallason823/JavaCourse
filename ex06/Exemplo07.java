import java.util.Scanner;

public class Exemplo07 {
    public static Scanner input = new Scanner(System.in);

    public static boolean isSort(int[] v) {
        boolean result = true;
        for (int i = 1; i < v.length; i+=1) {
            if(v[i] < v[i-1]) {
                result = false;
                break;
            }
        }
        if (result) {
            return true;
        }
        for (int i = 1; i < v.length; i+=1) {
            if(v[i] > v[i-1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] v = {5, -1, 5, 6, 7, 8};
        System.out.println(isSort(v));
    }
}
