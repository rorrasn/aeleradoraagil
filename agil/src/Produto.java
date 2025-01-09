import java.util.Objects;

public class Produto {
    private int id =0 , contadorId = 1; 
    private String nome;
    private String categoria;
    private int quantidade; 
    private double preco;

    // construtor
    public Produto(String nome, String categoria, int quantidade, double preco) {
        this.id = contadorId++;
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    // metodos get
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    // metodos set
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // ToString
    @Override
    public String toString() {
        return id + nome + categoria + quantidade + preco;}
    

    // eguals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Produto produto = (Produto) obj;
        return id == produto.id;
    }

    // hash code
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}