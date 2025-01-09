
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();

        while (true) {
            System.out.println("\n1. Adicionar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Buscar Produto");
            System.out.println("4. Atualizar Produto");
            System.out.println("5. Excluir Produto");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer de nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Categoria: ");
                    String categoria = scanner.nextLine();
                    System.out.print("Quantidade em Estoque: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    inventario.adicionarProduto(nome, categoria, quantidade, preco);
                    break;

                case 2:
                    inventario.listarProdutos();
                    break;

                case 3:
                    System.out.print("Digite o ID do Produto: ");
                    int busca = scanner.nextInt();
                    try {
                        Produto produto = (Produto) inventario.buscarProduto(busca);
                        if (produto != null) {
                            System.out.println(produto);
                        } else {
                            System.out.println("Produto não encontrado.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Nenhum produto encontrado.");
                    }

                    break;

                case 4:
                    System.out.print("Digite o ID do Produto a ser atualizado: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    System.out.print("Novo Nome (deixe em branco para não alterar): ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Nova Categoria (deixe em branco para não alterar): ");
                    String novaCategoria = scanner.nextLine();
                    System.out.print("Nova Quantidade (digite -1 para não alterar): ");
                    int novaQuantidade = scanner.nextInt();
                    System.out.print("Novo Preço (digite -1 para não alterar): ");
                    double novoPreco = scanner.nextDouble();
                    inventario.atualizarProduto(idAtualizar, novoNome.isEmpty() ? null : novoNome, novaCategoria.isEmpty() ? null : novaCategoria, novaQuantidade == -1 ? -1 : novaQuantidade, novoPreco == -1 ? -1 : novoPreco);
                    break;

                case 5:
                    System.out.print("Digite o ID do Produto a ser excluído: ");
                    int idExcluir = scanner.nextInt();
                    inventario.excluirProduto(idExcluir);
                    break;

                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
