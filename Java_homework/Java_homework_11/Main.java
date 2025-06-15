import java.util.Scanner;

public class Main {
    
    public static Scanner input = new Scanner(System.in);

    public static int encontrarPessoa(Pessoa[] v, int qtd, String nome) {
        for (int i = 0; i < qtd; i++) {
            if (v[i].nome.toUpperCase().compareTo(nome.toUpperCase()) == 0) {
                return i;
            }
        }
    return -1;
    }

    public static int cadastrarPessoa(Pessoa[] v, int qtd) {
        String nome;
        boolean val_inserir;
        if (qtd < v.length) {
            do {
                System.out.println("Digite o nome: ");
                nome = input.nextLine();
                val_inserir = encontrarPessoa(v, qtd, nome) == -1 ? true : false;
                if (!val_inserir) {
                    System.out.println("O nome já está cadastrado!");
                }
            } while(!val_inserir);
            v[qtd] = new Pessoa();
            v[qtd].nome = nome;
            System.out.println("Digite a idade: ");
            v[qtd].idade = input.nextInt();
            System.out.println("Digite o peso: ");
            v[qtd].peso = input.nextDouble();
            System.out.println("Digite a altura: ");
            v[qtd].altura = input.nextDouble();
            input.nextLine();
        }
        System.out.println("O vetor Pessoas está cheio!");
        return qtd;
    }

    public static double calcularIMC(Pessoa p) {
        return p.peso/(p.altura*p.altura);
    }

    public static void imprimirPessoas(Pessoa[] v, int qtd) {
        if (qtd <= 0) {
            System.out.println("O vetor de Pessoas está vazio!");
        }
        for (int i = 0; i < qtd; i++) {
            System.out.printf("Pessoa %d: {%s, %d anos, %.2f kg, %.2f m, IMC = %.2f}", i+1, v[i].nome, v[i].idade, v[i].peso, v[i].altura, calcularIMC(v[i]));
        }
    }

    public static int maisVelhaIMCMagreza(Pessoa[] v, int qtd) {
        boolean existe_imc_magreza = false;
        int idx = 0;
        for (int i = 0; i < qtd; i++) {
            if (!existe_imc_magreza && calcularIMC(v[i]) < 18.5) {
                existe_imc_magreza = true;
                idx = i;
            }
            if (existe_imc_magreza && calcularIMC(v[i]) < 18.5 && v[idx].idade < v[i].idade) {
                idx = i;
            }
        }
        if (!existe_imc_magreza) {
            return -1;
        }
        return idx;
    }

    public static void insertionSortPorNome(Pessoa[] v, int qtd) {
        Pessoa key;
        int j;
        for (int i = 1; i < qtd; i++) {
            key = v[i];
            j = i;
            while (j>0 && key.nome.toUpperCase().compareTo(v[j-1].nome.toUpperCase()) < 0) {
                v[j] = v[j-1];
                j -= 1;
            }
            v[j] = key;
        }
    }

    //buscaBinariaPorNome --> recebe um vetor de Pessoas (input) com preenchimento qtd (input) ordenado pelo campo Nome em ordem alfabetica e retorna idx do nome (input) buscado caso o encontre em caso contrario retorna -1
    public static int buscaBinariaPorNome(Pessoa[] v, int qtd, String nome) {
        int meio, inicio = 0, fim = qtd-1;
        while(inicio <= fim) {
            meio = (inicio+fim)/2;
            if (v[meio].nome.toUpperCase().compareTo(nome.toUpperCase()) == 0) {
                return meio;
            } else if (v[meio].nome.toUpperCase().compareTo(nome.toUpperCase()) < 0) {
                inicio = meio+1;
            } else {
                fim = meio-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}