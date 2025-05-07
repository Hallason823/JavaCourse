public class Exemplo11 {

    public static void reverseArray(int[] arr, int n){
        int aux = 0;
        for (int i = 0; i < n/2; i++) {
            aux = arr[i];
            arr[i] = arr[n-i];
            arr[n-i] = aux;
        }
    }
    public static void main(String[] args) {

    }

}