import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque();
        List<Cliente> clientes = new ArrayList<>();
        List<Pedido> pedidos = new ArrayList<>();

        System.out.print("Defina o nível mínimo de estoque: ");
        int nivelMinimo = scanner.nextInt();
        scanner.nextLine();

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Adicionar Produto");
            System.out.println("2 - Remover Produto");
            System.out.println("3 - Remover Quantidade de um Produto");
            System.out.println("4 - Adicionar Quantidade a um Produto");
            System.out.println("5 - Gerar Relatório");
            System.out.println("6 - Cadastrar Cliente");
            System.out.println("7 - Listar Clientes");
            System.out.println("8 - Processar Pedido");
            System.out.println("9 - Relatório de Vendas");
            System.out.println("10 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = -1;

            while (true) {
                try {
                    opcao = scanner.nextInt();
                    scanner.nextLine();
                    if (opcao >= 1 && opcao <= 10) {
                        break;
                    } else {
                        System.out.println("Entrada inválida! Por favor, insira uma opção válida.");
                    }
                } catch (Exception e) {
                    System.out.println("Entrada inválida! Tente novamente.");
                    scanner.nextLine();
                }
            }

            switch (opcao) {
                case 1:
                    int id = 0;
                    while (true) {
                        try {
                            System.out.print("ID do Produto: ");
                            id = scanner.nextInt();
                            scanner.nextLine();
                            if (estoque.buscarProdutoPorId(id) != null) {
                                System.out.println("ID já existente. Escolha outro.");
                            } else {
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("ID inválido! Insira um número inteiro.");
                            scanner.nextLine();
                        }
                    }

                    System.out.print("Nome do Produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Descrição do Produto: ");
                    String descricao = scanner.nextLine();

                    int quantidade = 0;
                    while (true) {
                        try {
                            System.out.print("Quantidade: ");
                            quantidade = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Quantidade inválida! Insira um número inteiro.");
                            scanner.nextLine();
                        }
                    }

                    double preco = 0.0;
                    while (true) {
                        try {
                            System.out.print("Preço: ");
                            preco = scanner.nextDouble();
                            scanner.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Preço inválido! Insira um número decimal.");
                            scanner.nextLine();
                        }
                    }

                    Produto novoProduto = new Produto(id, nome, descricao, quantidade, preco);
                    estoque.adicionarProduto(novoProduto);
                    break;

                case 2:
                    int idRemover = 0;
                    while (true) {
                        try {
                            System.out.print("ID do Produto a remover: ");
                            idRemover = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("ID inválido! Insira um número inteiro.");
                            scanner.nextLine();
                        }
                    }
                    estoque.removerProduto(idRemover);
                    break;

                case 3:
                    System.out.print("ID do Produto: ");
                    int idProdutoRemover = scanner.nextInt();
                    System.out.print("Quantidade a remover: ");
                    int qtdRemover = scanner.nextInt();
                    estoque.removerQuantidadeProduto(idProdutoRemover, qtdRemover);
                    break;

                case 4:
                    System.out.print("ID do Produto: ");
                    int idAdd = scanner.nextInt();
                    System.out.print("Quantidade a adicionar: ");
                    int qtdAdicionar = scanner.nextInt();
                    estoque.adicionarQuantidadeProduto(idAdd, qtdAdicionar);
                    break;

                case 5:
                    estoque.gerarRelatorio(nivelMinimo);
                    break;

                case 6:
                    int idCliente = 0;
                    while (true) {
                        try {
                            System.out.print("ID do Cliente: ");
                            idCliente = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("ID inválido! Insira um número inteiro.");
                            scanner.nextLine();
                        }
                    }

                    System.out.print("Nome: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Contato: ");
                    String contato = scanner.nextLine();

                    clientes.add(new Cliente(idCliente, nomeCliente, endereco, contato));
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;


                case 7:
                    System.out.println("\n=== Lista de Clientes ===");
                    for (Cliente c : clientes) {
                        System.out.println(c);
                    }
                    break;

                case 8:
                    System.out.print("ID do Cliente para o pedido: ");
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

                    Pedido pedido = new Pedido(pedidos.size() + 1, clientePedido);
                    
                    while (true) {
                        System.out.print("ID do Produto para adicionar ao pedido (ou 0 para finalizar): ");
                        int idProdPedido = scanner.nextInt();
                        if (idProdPedido == 0) break;
                        
                        Produto produtoPedido = estoque.buscarProdutoPorId(idProdPedido);
                        if (produtoPedido != null) {
                            pedido.adicionarProduto(produtoPedido);
                        } else {
                            System.out.println("Produto não encontrado!");
                        }
                    }
                    
                    pedidos.add(pedido);
                    System.out.println("Pedido registrado com sucesso!");
                    break;

                case 9:
                    System.out.println("\n=== Relatório de Vendas ===");
                    for (Pedido p : pedidos) {
                        System.out.println(p);
                    }
                    break;

                case 10:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
