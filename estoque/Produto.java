import java.util.ArrayList;
import java.util.List;

public class Produto {
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
        this.quantidade += quantidade;
        
        movimentacoes.add(new Movimentacao("entrada", quantidade)); 
    }

    public void removerQuantidade(int quantidade) {
        if (quantidade > this.quantidade) {
            throw new IllegalArgumentException("Quantidade insuficiente no estoque.");
        }
        this.quantidade -= quantidade;
        movimentacoes.add(new Movimentacao("saida", quantidade)); 
    }
}
