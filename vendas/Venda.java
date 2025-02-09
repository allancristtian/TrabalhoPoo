import java.util.ArrayList;
import java.util.List;


class SistemaVendas {
    public List<Pedido> pedidos;

    public SistemaVendas() {
        this.pedidos = new ArrayList<>();
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
        System.out.println("Pedido registrado com sucesso!");
    }

    public void gerarRelatorioVendas() {
        RelatorioVendas.gerarRelatorio(pedidos);
    }
}

