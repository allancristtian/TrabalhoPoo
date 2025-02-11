import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Produto implements Serializable {
    private int id;
    private String nome;
    private String descricao;
    private int quantidade;
    private double preco;
    private List<Movimentacao> movimentacoes;

    public Produto(int id, String nome, String descricao, int quantidade, double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.movimentacoes = new ArrayList<>();
    }

    public Produto(int id, String nome, double preco) {
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void adicionarMovimentacao(Movimentacao movimentacao) {
        this.movimentacoes.add(movimentacao);
    }

    public void adicionarQuantidade(int quantidade) {
        int quantidadeAnterior = this.quantidade; 
        this.quantidade += quantidade;
        movimentacoes.add(new Movimentacao("entrada", quantidade, quantidadeAnterior)); 
    }

    public void removerQuantidade(int quantidade) {
        if (quantidade > this.quantidade) {
            throw new IllegalArgumentException("Quantidade insuficiente no estoque.");
        }
        int quantidadeAnterior = this.quantidade;
        this.quantidade -= quantidade;
        movimentacoes.add(new Movimentacao("saida", quantidade, quantidadeAnterior)); 
    }

    public static Produto fromString(String linha) {
        String[] partes = linha.split(";");
        int id = Integer.parseInt(partes[0]);
        String nome = partes[1];
        String descricao = partes[2];
        int quantidade = Integer.parseInt(partes[3]);
        double preco = Double.parseDouble(partes[4]);
        return new Produto(id, nome, descricao, quantidade, preco);
    }
}
