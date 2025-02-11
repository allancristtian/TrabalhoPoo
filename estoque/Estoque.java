import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }
    public List<Produto> getProdutos() {
        return produtos;
    }
    public void adicionarProduto(Produto produto) {
        if (produto.getQuantidade() < 0 || produto.getPreco() < 0) {
            throw new IllegalArgumentException("Não é permitido adicionar produtos com valores negativos.");
        }
        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    public boolean verificarIdExistente(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return true; 
            }
        }
        return false; 
    }

    public Produto buscarProdutoPorId(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }
    

    public void removerProduto(int id) {
        boolean removido = produtos.removeIf(p -> p.getId() == id);
        if (removido) {
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void adicionarQuantidadeProduto(int id, int quantidade) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                if (quantidade < 0) {
                    throw new IllegalArgumentException("Quantidade não pode ser negativa.");
                }
                p.adicionarQuantidade(quantidade);
                System.out.println("Quantidade adicionada com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    public void removerQuantidadeProduto(int id, int quantidade) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                try {
                    p.removerQuantidade(quantidade);
                    System.out.println("Quantidade removida com sucesso!");
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    public void gerarRelatorio(int nivelMinimo) {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
    
        System.out.println("\n=== RELATÓRIO DE PRODUTOS ===");
        for (Produto p : produtos) {
            System.out.printf("Produto { ID: %d, Nome: '%s', Descrição: '%s', Quantidade: %d, Preço: %.2f }\n",
                              p.getId(), p.getNome(), p.getDescricao(), p.getQuantidade(), p.getPreco());
    
            if (p.getQuantidade() < nivelMinimo) {
                System.out.println("ALERTA: Estoque abaixo do nível mínimo!");
            }
    
            if (p.getMovimentacoes().isEmpty()) {
                System.out.println("Sem movimentações registradas.");
            } else {
                System.out.println("Movimentações: ");
                for (Movimentacao m : p.getMovimentacoes()) {
                    System.out.println(m); 
                }
            }
        }
    }    
}      

    
