package estoque;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(int id) {
        produtos.removeIf(p -> p.getId() == id);
    }

    public void gerarRelatorio() {
        for (Produto p : produtos) {
            System.out.println(p.getNome() + " - Quantidade: " + p.getQuantidade());
        }
    }
}
