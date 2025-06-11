import java.util.Scanner;

public class Main {
    
    public static final int TAM = 100;

    public static Scanner input = new Scanner(System.in);

    public static int buscarCategoria(Categoria[] v, int qtd, int x) {
        for (int i = 0; i < qtd; i++) {
            if (v[i].codigo == x) {
                return i;
            }
        }
        return -1;
    }

    public static int buscarProduto(Produto[] v, int qtd, int x) {
        for (int i = 0; i < qtd; i++) {
            if (v[i].codigo == x) {
                return i;
            }
        }
        return -1;
    }

    public static int cadastrarCategoria(Categoria[] v, int qtd) {
        if (qtd >= v.length) {
            System.out.println("Vetor Categoria esta cheio!");
            return qtd;
        }
        v[qtd] = new Categoria();
        do {
            System.out.println("Digite o codigo da categoria, precisa ser unico: ");
            v[qtd].codigo = input.nextInt();
        } while(buscarCategoria(v, qtd, v[qtd].codigo) != -1);
            input.nextLine();
            System.out.println("Digite o nome da categoria: ");
            v[qtd].nome = input.nextLine();
        return qtd+1;
    }

    public static int cadastrarProduto(Produto[] v, int qtd) {
        if (qtd >= v.length) {
            System.out.println("Vetor Produto esta cheio!");
            return qtd;
        }
        v[qtd] = new Produto();
        do {
            System.out.println("Digite o codigo do produto, precisa ser unico: ");
            v[qtd].codigo = input.nextInt();
        } while(buscarProduto(v, qtd, v[qtd].codigo) != -1);
            input.nextLine();
            System.out.println("Digite o tiutlo do produto: ");
            v[qtd].titulo = input.nextLine();
            System.out.println("Digite a descricao do produto: ");
            v[qtd].descricao = input.nextLine();
            System.out.println("Digite a caregoria do produto: ");
            v[qtd].categoria = input.nextInt();
            System.out.println("Digite o preco do produto: ");
            v[qtd].preco = input.nextInt();
        return qtd+1;
    }

    public static void imprimirCategorias(Categoria[] v, int qtd) {
        System.out.println("-----IMPRESSAO CATEGORIAS-----");
        for (int i = 0; i < qtd; i+=1) {
            System.out.printf("(%d, %s)\n", v[i].codigo, v[i].nome);
        }
    }

    
    public static void imprimirProdutos(Produto[] vp, Categoria[] vc, int qtdProd, int qtdCat) {
        int pos;
        String categoria = "Desconhecida";
        System.out.println("-----IMPRESSAO PRODUTOS-----");
        for (int i = 0; i < qtdProd; i+=1) {
            pos = buscarCategoria(vc, qtdCat, vp[i].categoria);
            if (pos != -1) {
                categoria = vc[pos].nome;
            }
            System.out.printf("(%d, %s, %s, %s, %.2f)\n", vp[i].codigo, vp[i].titulo, vp[i].descricao, categoria, vp[i].preco / 100.0);
        }
    }



    public static void main(String[] args) {
        Categoria[] categorias = new Categoria[TAM];
        Produto[] produtos = new Produto[TAM];
        int opcao, qtdCat = 0, qtdProd = 0;
        do {
            System.out.println("\nM E N U");
            System.out.println("1 - Cadastrar Categoria");
            System.out.println("2 - Imprimir Categorias");
            System.out.println("3 - Cadastrar Produto");
            System.out.println("4 - Imprimir Produtos");
            System.out.println("Dgitie uma opcao: ");
            opcao = input.nextInt();
            switch (opcao) {
                case 1:
                    qtdCat = cadastrarCategoria(categorias, qtdCat);
                    break;
                case 2:
                    imprimirCategorias(categorias, qtdCat);
                    break;
                case 3:
                    qtdProd = cadastrarProduto(produtos, qtdProd);
                case 4:
                    imprimirProdutos(produtos, categorias, qtdProd, qtdCat);
                default:
                    if (opcao != 0) {
                        System.out.println("Opcao invalida!");
                    }
            }
        } while( opcao != 0);


    }
}
