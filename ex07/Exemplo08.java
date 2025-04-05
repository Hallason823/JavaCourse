import java.util.Random;

public class Exemplo08 {

    public static final int TAM = 1000;

    public static Random geradorAleat = new Random(5);

    public static void preencherAleatorio1(int[] v) {
        int x;
        for (int i = 0; i < v.length; i += 1) {
            x =  geradorAleat.nextInt(TAM)+1;
            while (busca(v, i, x) != -1) {
               x = geradorAleat.nextInt(TAM) + 1;
            }
            v[i] = x;
        }
    }

    public static void preencherAleatorio2(int[] v) {
        int pos, aux;
        for (int i = 0; i < v.length; i += 1) {
            v[i] = i+1;
        }
        for (int i = 0; i < v.length; i++) {
            pos = geradorAleat.nextInt(TAM);
            aux = v[i];
            v[i] = v[pos];
            v[pos] = aux;
        }
    }

    public static void imprimir(int[] v) {
        for (int i = 0; i < v.length; i+=1) {
            System.out.printf("%4d ", v[i]);
            if ((i+1)%20 == 0) {
                System.out.println();
            }
        }
    }

    public static int busca (int[] v, int n, int x) {
        for (int i = 0; i < n; i += 1) {
            if (v[i] == x){
                return i;
            }
        }
        return -1;
    }

    public static void main (String[] args) {
        int[] numeros = new int[TAM];
        preencherAleatorio2(numeros);
        imprimir(numeros);
    } 

}
