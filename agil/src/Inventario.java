
import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<Produto> produtos;

    public Inventario() {
        produtos = new ArrayList<>();
    }

    // Adicionar produto
    public void adicionarProduto(String nome, String categoria, int quantidade, double preco) {
        Produto produto = new Produto(nome, categoria, quantidade, preco);
        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    // Listar todos os produtos
    public void listarProdutos() {
        for (Produto produto : produtos) {
            System.out.println(produto + " , ");
        }
    }

    // Buscar Produto por ID
    public List<Produto> buscarProduto(int id) {
        List<Produto> buscaList = new ArrayList<>();
        if (!produtos.isEmpty()) {
            for (Produto p : produtos) {
                if (p.getId() == id) {
                    return produtos;
                }

            }
        }
                return buscaList ;
    }
   
   

   
    // Atualizar Produto
    public boolean atualizarProduto(int id, String nome, String categoria, int quantidade, double preco) {
        Produto produto = (Produto) buscarProduto(id);
        if (produto != null) {
            if (nome != null && !nome.isEmpty()) {
                produto.setNome(nome);
            }
            if (categoria != null && !categoria.isEmpty()) {
                produto.setCategoria(categoria);
            }
            if (quantidade >= 0) {
                produto.setQuantidade(quantidade);
            }
            if (preco >= 0) {
                produto.setPreco(preco);
            }
            System.out.println("Produto atualizado com sucesso!");
            return true;
        } else {
            System.out.println("Produto não encontrado.");
        }
        return false;
    }

    // Excluir Produto
    public boolean excluirProduto(int id) {
        Produto produto = (Produto) buscarProduto(id);
        if (produto != null) {
            produtos.remove(produto);
            System.out.println("Produto excluído com sucesso!");
            return true;
        }
        System.out.println("Produto não encontrado.");
        return false;
    }
}
