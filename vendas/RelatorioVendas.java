import java.util.ArrayList;
import java.util.List;


class RelatorioVendas {
    public static void gerarRelatorio(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado.");
            return;
        }

        double totalVendas = 0;
        System.out.println("\n--Relatório de vendas--");
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
            totalVendas += pedido.getTotal();
        }
        System.out.println("Total de vendas: " + totalVendas);
    }
}
