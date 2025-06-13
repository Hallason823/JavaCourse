import java.util.Scanner;

public class Gerenciador {

    public static final int TAM = 10;

    public static Scanner input = new Scanner(System.in);

    public static int acharCategoriaCadastrada(Categoria[] v, int qtd, int id) {
        for (int i = 0; i < qtd; i++) {
            if (v[i].codigo == id) {
                return i;
            }
        }
        return -1;
    }

    public static int cadastrarCategoria(Categoria[] v, int qtd) {
        boolean ja_cadastrou;
        int id;
        if (qtd < v.length) {
            v[qtd] = new Categoria();
            do {
                System.out.println("\nInforme o codigo da Categoria: ");
                id = input.nextInt();
                ja_cadastrou = acharCategoriaCadastrada(v, qtd, id) >= 0 ? true : false;
                if (ja_cadastrou) {
                    System.out.println("\nCategoria ja cadastrada");
                }
            } while(ja_cadastrou);
            input.nextLine();
            v[qtd].codigo = id;
            System.out.println("\nInforme o nome da Categoria: ");
            v[qtd].nome = input.nextLine();
            return qtd+1;
        }
            System.out.println("\nA array de categorias esta cheio!");
            return qtd;
    }

    public static void imprimirUnicaCategoria(Categoria categoria) {
        System.out.printf("\nCategoria: {codigo: %d, nome %s}\n", categoria.codigo, categoria.nome);
    }

    public static void imprimirCategorias(Categoria[] v, int qtd) {
        if (qtd > 0) {
            for (int i = 0; i < qtd; i++) {
                imprimirUnicaCategoria(v[i]);
            }
        }
        else {
            System.out.println("\nA array de categorias esta vazia!");
        }
    }

    public static void imprimirProdutos(Produto[] vp, int qtdProdutos, Categoria[] vc, int qtdCategorias) {
        int idx;
        String categoria_nome;
        if (qtdProdutos > 0 ) {
            for (int i = 0; i < qtdProdutos; i++) {
                idx = acharCategoriaCadastrada(vc, qtdCategorias, vp[i].categoria);
                categoria_nome = idx >=0 ? vc[idx].nome : "No found";
                System.out.printf("\nProduto: {Codigo: %d, Titulo: %s, Descricao: %s, Nome da categoria: %s, Preco: R$ %.2f}",
                                                      vp[i].codigo, vp[i].titulo, vp[i].descricao, categoria_nome, (double) vp[i].preco);
            }
        }
        else {
            System.out.println("\nA array de produtos esta vazia!");
        }
    }

    public static void InsertionSortPorDescricao(Produto[] v, int qtd) {
        Produto key;
        int j;
        for (int i = 1; i < qtd; i++) {
            key = v[i];
            j = i;
            while(j > 0 && key.descricao.toUpperCase().compareTo(v[j-1].descricao.toUpperCase()) < 0) {
                v[j] = v[j-1];
                j--;
            }
            v[j] = key;
        }
    }

    public static void SelectionSortDescricao(Produto[] v, int qtd) {
        int menor;
        Produto aux;
        for (int i = 0; i < qtd - 1; i += 1) {
            menor = i;
            for (int j = i + 1; j <= qtd - 1; j += 1) {
                if (v[j].descricao.toUpperCase().compareTo(v[menor].descricao.toUpperCase()) < 0) {
                menor = j;
                }
            }
            aux = v[i];
            v[i] = v[menor];
            v[menor] = aux;
        }  
    }

    public static int buscaBinariaPorDescricao(Produto[] v, int qtd, String x) {
        int meio, inicio = 0, fim = qtd - 1;
        while (inicio <= fim) {
            meio = (inicio+fim)/2;
            if (v[meio].descricao.toUpperCase().compareTo(x.toUpperCase()) == 0) {
                return meio;
            } else if (v[meio].descricao.toUpperCase().compareTo(x.toUpperCase()) > 0) {
                fim = meio-1; 
            } else {
                inicio = meio+1;
            }
        }
        return -1;
    }    

    public static void main(String[] args) {
        Categoria[] categorias = new Categoria[TAM];
        Produto[] produtos = new Produto[TAM];
    }
}