import java.util.Scanner;


public class Exemplo10 {
    public static final int TAM = 3;
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int[] vetor1 = new int[TAM];
        int opcao, num, pos, qtd_vetor1 = 0;
        double media;
        do {
            System.out.println("MENU");
            System.out.println("1. Inserir valor no vetor");
            System.out.println("2. Imprimir vetor");
            System.out.println("3. Ordenar vetor");
            System.out.println("4. Pesquisar no vetor");
            System.out.println("5. Calcular a media");
            System.out.println("Digite sua opcao (0 p/ sair): ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    qtd_vetor1 =  inserirVetor(vetor1, qtd_vetor1);
                    break;
                case 2:
                    imprimirVetor(vetor1, qtd_vetor1);
                    break;
                case 3:
                    insercaoDireta(vetor1, qtd_vetor1);
                    imprimirVetor(vetor1, qtd_vetor1);
                    break;
                case 4:
                    System.out.print("Digite o numero a ser pesquisado: ");
                    num = input.nextInt();
                    insercaoDireta(vetor1, qtd_vetor1);
                    pos = busca(vetor1, qtd_vetor1, num);
                    if (pos != -1) {
                        System.out.println("Achou o numero " + num + " na posicao " + (pos+1));
                    }
                    else {
                        System.out.println("Nao achou o numero " + num + " no vetor");
                    }
                    break;
                case 5:
                    media = calcularMedia(vetor1, qtd_vetor1);
                    System.out.println("A media eh: " + media);
                    break;
                default:
                    if (opcao != 0) {
                        System.out.println("Opcao nao valida!");
                    }
                    break;
            }
        } while (opcao != 0);
    }

    public static int inserirVetor(int[] v, int n) {
        if (n < v.length) {
            System.out.print("Digite um valor: ");
            v[n] = input.nextInt();
            n+=1;
        }
        else {
            System.out.println("Vetor cheio, nao pode inserir mais elementos.");
        }
        return n;
    }

    public static void imprimirVetor(int[] v, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(v[i]+ "\t");
        }
        System.out.println("");
    }
    public static void metodoBolha(int[] v, int n) {
        int fim = n - 2, pos = 0;
        boolean trocou = true;
        int chave;
        while (trocou) {
        trocou = false;
        for (int i = 0; i <= fim; i++) {
            if (v[i] > v[i+1]) {
            chave = v[i]; v[i] = v[i+1]; v[i+1] = chave;
            pos = i; trocou = true;
            }
        }
        fim = pos-1;
        }
    }

    public static void insercaoDireta(int[] v, int n) {
        int i, j;
        int chave;
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

    public static int busca(int[] v, int n, int x) {
        for (int i = 0; i < n; i += 1) {
          if (v[i] == x) {
            return i;
          }
        }
        return -1;
    }

    public static double calcularMedia(int[] v, int n) {
        int sum = 0;
        if (n == 0) {
            return 0.0;
        }
        for (int i = 0; i < n; i++) {
            sum += v[i];
        }
        return (double) sum/ (double) n;
    }

    public static int menorPar(int[] v, int n) {
        int i = 0, posicao;
        while(i < n && v[i]%2 != 0) {
            i += 1;
        }
        if (i == n) {
            return -1;
        }
        posicao = i;
        for (i = posicao+1; i < n; i++) {
            if (v[i]%2 == 0 && v[i] < v[posicao]) {
                posicao = i;
            }
        }
        return posicao;
    }

    public static void imprimirDuplicados(int[] v, int n) {
        insercaoDireta(v, n);
        int qtd = 1;
        System.out.println("NUM\tQUAN");
        for (int i = 1; i < n; i+=1) {
            if (v[i] == v[i-1]) {
                qtd += 1;
            } else {
                System.out.println(v[i-1] + "\t" + qtd);
                qtd =1;
            }
        }
        System.out.println(v[n-1] + "\t" + qtd);
    }
}