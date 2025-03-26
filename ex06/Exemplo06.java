import java.util.Scanner;

public class Exemplo06 {

    public static Scanner input = new Scanner(System.in);

    public static void inserirNotas (double[] v) {
        double nota;
        for (int i = 0; i < v.length; i += 1) {
            System.out.print("Digite a " + (i+1) + "º nota: ");
            nota = input.nextDouble();
            inserirOrdenado(v, i, nota);
        }
    }

    public static void inserirOrdenado(double[] v, int pos, double x) {
        if (pos == 0) {
            v[pos] = x;
        } else if (v[pos-1] > x) {
            v[pos] = v[pos-1];
            inserirOrdenado(v, pos-1, x);
        } else {
            v[pos] = x;
        }
    }

    public static void printNotas (double[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.println("A " + (i+1) + "º nota eh: " + v[i]);
        }
    }

    public static double obterMediaNotas (double[] v) {
        double sum = 0;
        for (int i = 0; i < v.length; i += 1) {
            sum += v[i];
        }
        return sum/v.length;
    }

    public static double obterStdNotas (double[] v) {
        double std = 0;
        double media = obterMediaNotas(v);
        for (int i = 0; i < v.length; i+=1){
            std += Math.pow((v[i]-media), 2);
        }
        return Math.sqrt(std/(v.length-1));
    }

    public static void printNotasMaiorIgualValor (double[] v, double valor) {
        int count = 0;
        System.out.println("As notas maior ou igual ao valor " + valor + "da turma: ");
        for(int i = 0; i < v.length; i += 1) {
            if (v[i] > valor) {
                System.out.print(v[i] + " ");
                count += 1;
            }
        }
        System.out.println("\nO total de notas maior ou igual ao valor " + valor + " da turma eh: " + (int) count);
    }

    public static int busca (double[] v, double x) {
        for (int i = 0; i < v.length; i += 1) {
            if (v[i] == x){
                return i;
            }
        }
        return -1;
    }

    public static int buscaMelhorada (double[] v, double x) {
        int i = 0;
        while (i < v.length && v[i] < x) {
            i+=1;
        }
        if (i < v.length && v[i] == x) {
            return i;
        }
        return -1;
    }

    public static void buscaNotasEnquantoNotaNaoNegativa (double[] v) {
        double nota; int pos;
        System.out.print("Digite uma nota a ser pesquisada: ");
        nota = input.nextDouble();
        pos = buscaMelhorada(v, nota);
        while (nota >= 0.0) {
            pos = busca(v, nota);
            if (pos != -1) {
                System.out.println("A nota " + nota + " foi encontrada na posição " + (pos+1) + "º");
            }
            else {
                System.out.println("A nota " + nota + " não foi encontrada");
            }
            System.out.print("Digite uma nota a ser pesquisada (< 0.0 para finalizar):");
            nota = input.nextDouble();
        }
    }

    public static void main (String[] args) {
        double[] notas = new double[5];
        double media, std;
        inserirNotas(notas);
        printNotas(notas);;
        media = obterMediaNotas(notas);
        System.out.println("A media da turma eh: " + media);
        printNotasMaiorIgualValor(notas, media);
        std = obterStdNotas(notas);
        System.out.println("O desvio padrao eh: " + std);
        buscaNotasEnquantoNotaNaoNegativa(notas);
    }  
}