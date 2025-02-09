import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque();

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
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = -1;

            
            while (true) {
                try {
                    opcao = scanner.nextInt();
                    scanner.nextLine(); 
                    if (opcao >= 1 && opcao <= 6) {
                        break; 
                    } else {
                        System.out.println("Entrada inválida! Por favor, insira uma das opções do menu.");
                    }
                } catch (Exception e) {
                    System.out.println("Entrada inválida! Por favor, insira uma das opções do menu.");
                    scanner.nextLine(); 
                }
            }

            switch (opcao) {
                case 1:
                    int id = 0;
                    boolean idValido = false;

                    while (!idValido) {
                        try {
                            System.out.print("ID do Produto: ");
                            id = scanner.nextInt();
                            scanner.nextLine(); 
                            if (estoque.buscarProdutoPorId(id) != null) {
                                System.out.println("ID já existente. Por favor, insira outro.");
                            } else {
                                idValido = true;  
                            }
                        } catch (Exception e) {
                            System.out.println("ID inválido. Por favor, insira um número inteiro.");
                            scanner.nextLine(); 
                        }
                    }

                    
                    System.out.print("Nome do Produto: ");
                    String nome = scanner.nextLine();

                    
                    System.out.print("Descrição do Produto: ");
                    String descricao = scanner.nextLine();

                    
                    int quantidade = -1;
                    while (quantidade < 0) {
                        try {
                            System.out.print("Quantidade: ");
                            quantidade = scanner.nextInt();
                            scanner.nextLine(); 
                            if (quantidade < 0) {
                                throw new IllegalArgumentException("Quantidade não pode ser negativa.");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro: " + e.getMessage() + " Tente novamente.");
                            scanner.nextLine();
                        }
                    }

                    
                    double preco = -1;
                    while (preco < 0) {
                        try {
                            System.out.print("Preço: ");
                            preco = scanner.nextDouble();
                            scanner.nextLine(); 
                            if (preco < 0) {
                                throw new IllegalArgumentException("Preço não pode ser negativo.");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro: " + e.getMessage() + " Tente novamente.");
                            scanner.nextLine(); 
                        }
                    }

                    Produto novoProduto = new Produto(id, nome, descricao, quantidade, preco);
                    estoque.adicionarProduto(novoProduto);
                    break;

                case 2:
                    System.out.print("ID do Produto a remover: ");
                    int idRemover = scanner.nextInt();
                    estoque.removerProduto(idRemover);
                    break;

                case 3:
                    System.out.print("ID do Produto: ");
                    int idProdutoRemover = scanner.nextInt();

                    int qtdRemover = -1;
                    while (qtdRemover < 0) {
                        try {
                            System.out.print("Quantidade a remover: ");
                            qtdRemover = scanner.nextInt();
                            scanner.nextLine(); 
                            if (qtdRemover < 0) {
                                throw new IllegalArgumentException("Quantidade não pode ser negativa.");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro: " + e.getMessage() + " Tente novamente.");
                            scanner.nextLine(); 
                        }
                    }

                    estoque.removerQuantidadeProduto(idProdutoRemover, qtdRemover);
                    break;

                case 4:
                    System.out.print("ID do Produto: ");
                    int idAdd = scanner.nextInt();

                    int qtdAdicionar = -1;
                    while (qtdAdicionar < 0) {
                        try {
                            System.out.print("Quantidade a adicionar: ");
                            qtdAdicionar = scanner.nextInt();
                            scanner.nextLine(); 
                            if (qtdAdicionar < 0) {
                                throw new IllegalArgumentException("Quantidade não pode ser negativa.");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro: " + e.getMessage() + " Tente novamente.");
                            scanner.nextLine(); 
                        }
                    }

                    estoque.adicionarQuantidadeProduto(idAdd, qtdAdicionar);
                    break;

                case 5:
                    estoque.gerarRelatorio(nivelMinimo);
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
