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

    public static void main(String[] args) {

    }
}
