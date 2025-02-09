import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
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

    public void verificarEstoqueMinimo(int minimo) {
        for (Produto p : produtos) {
            if (p.getQuantidade() < minimo) {
                System.out.println("Alerta: Produto " + p.getNome() + " está abaixo do estoque mínimo!");
            }
        }
    }

    public void gerarRelatorio(int minimo) {
        System.out.println("\n--- Relatório de Estoque (Estoque abaixo de " + minimo + " unidades) ---");
        for (Produto p : produtos) {
            if (p.getQuantidade() < minimo) {
                System.out.println(p); 
            }
        }
    }
}

    
