import java.util.*;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque();
        SistemaVendas sistemaVendas = new SistemaVendas();
        List<Cliente> clientes = new ArrayList<>();

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Adicionar Produto");
            System.out.println("2 - Remover Produto");
            System.out.println("3 - Cadastrar Cliente");
            System.out.println("4 - Processar Pedido");
            System.out.println("5 - Relatório de Vendas");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("ID do Produto: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome do Produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();
                    Produto produto = new Produto(id, nome, preco);
                    estoque.adicionarProduto(produto);
                    System.out.println("Produto adicionado com sucesso!");
                    break;

                case 2:
                    System.out.print("ID do Produto a remover: ");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine();
                    estoque.removerProduto(idRemover);
                    break;

                case 3:
                    System.out.print("ID do Cliente: ");
                    int idCliente = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome do Cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Contato: ");
                    String contato = scanner.nextLine();
                    clientes.add(new Cliente(idCliente, nomeCliente, endereco, contato));
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 4:
                    System.out.print("ID do Cliente: ");
                    int idClientePedido = scanner.nextInt();
                    scanner.nextLine();
                    Cliente clientePedido = null;
                    for (Cliente c : clientes) {
                        if (c.getId() == idClientePedido) {
                            clientePedido = c;
                            break;
                        }
                    }
                    if (clientePedido == null) {
                        System.out.println("Cliente não encontrado!");
                        break;
                    }
                    Pedido pedido = new Pedido(sistemaVendas.pedidos.size() + 1, clientePedido);
                    while (true) {
                        System.out.print("ID do Produto para adicionar ao pedido (ou 0 para finalizar): ");
                        int idProd = scanner.nextInt();
                        if (idProd == 0) break;
                        Produto prodPedido = estoque.buscarProdutoPorId(idProd);
                        if (prodPedido != null) {
                            pedido.adicionarProduto(prodPedido);
                        } else {
                            System.out.println("Produto não encontrado!");
                        }
                    }
                    sistemaVendas.adicionarPedido(pedido);
                    break;

                case 5:
                    sistemaVendas.gerarRelatorioVendas();
                    break;

                case 6:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}