import java.util.Random;

public class Exemplo09 {
    public static final int TAM = 100;

    public static Random geradorAleat = new Random(5);

    public static void preencherAleatorio2(double[] v) {
        int pos;
        double aux;
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

    public static void imprimir(double[] v) {
        for (int i = 0; i < v.length; i+=1) {
            System.out.printf("%.2f ", v[i]);
            if ((i+1)%20 == 0) {
                System.out.println();
            }
        }
    }

    public static void insercaoDireta(double[] v, int n) {
        int i, j;
        double chave;
        for (i = 1; i <= n-1; i++) {
            chave = v[i];
            j = i-1;
            while (j >=0 && v[j] > chave) {
                v[j+1] = v[j];
                j = j-1;
            }
            v[j+1] = chave;
        }
    }

    public static void selecaoDireta(double[] v, int n) {
        int menor;
        double aux;
        for (int i = 0; i < n-1; i++) {
            menor = i;
            for (int j = i+1; j < n; j++) {
                if (v[menor] > v[j]) {
                    menor = j;
                }
            }
            aux = v[menor];
            v[menor] = v[i];
            v[i] = aux;
        }
    }

    public static void main(String[] args) {
        double[] v = new double[TAM];
        preencherAleatorio2(v);
        System.out.println("INPUT 1:");
        imprimir(v);
        System.out.println("OUTPUT 1:");
        insercaoDireta(v, TAM);
        imprimir(v);
        System.out.println("INPUT 2:");
        preencherAleatorio2(v);
        imprimir(v);
        System.out.println("OUTPUT 2:");
        selecaoDireta(v, TAM);
        imprimir(v);
    }
}