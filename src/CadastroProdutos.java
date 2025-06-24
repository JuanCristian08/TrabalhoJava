    import java.util.ArrayList;
    import java.util.Scanner;

    public class CadastroProdutos {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            ArrayList<String> nomes = new ArrayList<>();
            ArrayList<Double> precos = new ArrayList<>();

            int opcao;

            do {
                System.out.println("\n==== MENU DE OPÇÕES ====");
                System.out.println("1 - Cadastrar um produto");
                System.out.println("2 - Listar todos os produtos");
                System.out.println("3 - Mostrar o produto mais caro");
                System.out.println("4 - Calcular a média de preço dos produtos");
                System.out.println("5 - Listar produtos com preço acima da média");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Nome do produto: ");
                        String nome = scanner.nextLine();
                        System.out.print("Preço do produto: ");
                        double preco = scanner.nextDouble();
                        nomes.add(nome);
                        precos.add(preco);
                        break;

                    case 2:
                        System.out.println("\n--- Lista de Produtos ---");
                        for (int i = 0; i < nomes.size(); i++) {
                            System.out.println((i + 1) + ". " + nomes.get(i) + " - R$" + precos.get(i));
                        }
                        break;

                    case 3:
                        if (precos.size() > 0) {
                            double maiorPreco = 0;
                            String nomeProdutoMaisCaro = "";

                            for (int i = 0; i < precos.size(); i++) {
                                if (precos.get(i) > maiorPreco) {
                                    maiorPreco = precos.get(i);
                                    nomeProdutoMaisCaro= nomes.get(i);
                                }
                            }

                            System.out.println("Produto mais caro: " + nomeProdutoMaisCaro + " - R$" + maiorPreco);
                        } else {
                            System.out.println("Nenhum produto cadastrado.");
                        }
                        break;

                    case 4:
                        if (precos.size() > 0) {
                            double soma = 0;
                            for (double precoProdutos : precos) {
                                soma += precoProdutos;
                            }
                            double media = soma / precos.size();
                            System.out.println("Média de preço dos produtos: R$" + media);
                        } else {
                            System.out.println("Nenhum produto cadastrado.");
                        }
                        break;

                    case 5:
                        if (precos.size() > 0) {
                            double soma = 0;
                            for (double precoProduto : precos) {
                                soma += precoProduto;
                            }
                            double media = soma / precos.size();

                            System.out.println("\n--- Produtos com preço acima da média (R$" + media + ") ---");
                            boolean encontrou = false;
                            for (int i = 0; i < precos.size(); i++) {
                                if (precos.get(i) > media) {
                                    System.out.println((i + 1) + ". " + nomes.get(i) + " - R$" + precos.get(i));
                                    encontrou = true;
                                }
                            }

                            if (!encontrou) {
                                System.out.println("Nenhum produto com preço acima da média.");
                            }
                        } else {
                            System.out.println("Nenhum produto cadastrado.");
                        }
                        break;

                    case 0:
                        System.out.println("Encerrando o programa!");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcao != 0);

        }
    }
