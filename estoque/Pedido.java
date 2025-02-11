import java.util.*;

class Pedido {
    private int id;
    private Cliente cliente;
    private List<Produto> produtos;
    private double total;

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
        this.total = 0;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        total += produto.getPreco();
    }

    public double getTotal() { 
        return total; 
    }
    public Cliente getCliente() { 
        return cliente; 
    }
    public List<Produto> getProdutos() { 
        return produtos; 
    }

    @Override
    public String toString() {
        return "Pedido ID: " + id + ", Cliente: " + cliente.getNome() + ", Total: R$ " + total;
    }
    public static Pedido fromString(String linha, List<Cliente> clientes, Estoque estoque) {
        String[] partes = linha.split(";");
        int id = Integer.parseInt(partes[0]);
        int idCliente = Integer.parseInt(partes[1]);
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getId() == idCliente) {
                cliente = c;
                break;
            }
        }
        Pedido pedido = new Pedido(id, cliente);
        String[] idsProdutos = partes[2].split(",");
        for (String idProduto : idsProdutos) {
            if (!idProduto.isEmpty()) {
                Produto produto = estoque.buscarProdutoPorId(Integer.parseInt(idProduto));
                if (produto != null) {
                    pedido.adicionarProduto(produto);
                }
            }
        }
        return pedido;
    }
}
