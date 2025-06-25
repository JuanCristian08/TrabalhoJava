import java.util.ArrayList;
import java.util.Scanner;

public class CadastroProdutos {
    // Listas paralelas para armazenar nomes e preços dos produtos
    private static ArrayList<String> nomesProdutos = new ArrayList<>();
    private static ArrayList<Double> precosProdutos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CADASTRO DE PRODUTOS ===");
        System.out.println("Bem-vindo ao sistema!");
        
        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao();
            
            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    mostrarProdutoMaisCaro();
                    break;
                case 4:
                    calcularMediaPrecos();
                    break;
                case 5:
                    listarProdutosAcimaDaMedia();
                    break;
                case 6:
                    removerProduto();
                    break;
                case 7:
                    atualizarPrecoProduto();
                    break;
                case 8:
                    calcularTotalEstoque();
                    break;
                case 0:
                    System.out.println("Saindo do programa... Obrigado por usar nosso sistema!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            
            if (opcao != 0) {
                System.out.println("\nPressione ENTER para continuar...");
                scanner.nextLine();
            }
            
        } while (opcao != 0);
        
        scanner.close();
    }
    
    // Método para exibir o menu principal
    public static void exibirMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           MENU PRINCIPAL");
        System.out.println("=".repeat(50));
        System.out.println("1 - Cadastrar um produto");
        System.out.println("2 - Listar todos os produtos");
        System.out.println("3 - Mostrar produto mais caro");
        System.out.println("4 - Calcular média de preços");
        System.out.println("5 - Listar produtos acima da média");
        System.out.println("6 - Remover produto (Bonus)");
        System.out.println("7 - Atualizar preço (Bonus)");
        System.out.println("8 - Total do estoque (Bonus)");
        System.out.println("0 - Sair");
        System.out.println("=".repeat(50));
        System.out.print("Escolha uma opção: ");
    }
    
    // Método para ler a opção do menu com tratamento de erro
    public static int lerOpcao() {
        try {
            int opcao = Integer.parseInt(scanner.nextLine());
            return opcao;
        } catch (NumberFormatException e) {
            return -1; // Retorna -1 para opção inválida
        }
    }
    
    // Método para cadastrar um novo produto
    public static void cadastrarProduto() {
        System.out.println("\n--- CADASTRAR PRODUTO ---");
        
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine().trim();
        
        // Verificar se o nome não está vazio
        if (nome.isEmpty()) {
            System.out.println("Erro: Nome do produto não pode estar vazio!");
            return;
        }
        
        // Verificar se o produto já existe (desafio extra)
        if (produtoJaExiste(nome)) {
            System.out.println("Erro: Produto '" + nome + "' já está cadastrado!");
            return;
        }
        
        System.out.print("Digite o preço do produto (R$): ");
        try {
            double preco = Double.parseDouble(scanner.nextLine());
            
            if (preco < 0) {
                System.out.println("Erro: Preço não pode ser negativo!");
                return;
            }
            
            // Adicionar às listas paralelas
            nomesProdutos.add(nome);
            precosProdutos.add(preco);
            
            System.out.println("Produto cadastrado com sucesso!");
            System.out.printf("Produto: %s - Preço: R$ %.2f%n", nome, preco);
            
        } catch (NumberFormatException e) {
            System.out.println("Erro: Preço inválido! Digite apenas números.");
        }
    }
    
    // Método para verificar se produto já existe
    public static boolean produtoJaExiste(String nome) {
        for (String produto : nomesProdutos) {
            if (produto.equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }
    
    // Método para listar todos os produtos
    public static void listarProdutos() {
        System.out.println("\n--- LISTA DE PRODUTOS ---");
        
        if (nomesProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }
        
        System.out.println("Total de produtos: " + nomesProdutos.size());
        System.out.println("-".repeat(40));
        
        for (int i = 0; i < nomesProdutos.size(); i++) {
            System.out.printf("%d. %s - R$ %.2f%n", 
                (i + 1), nomesProdutos.get(i), precosProdutos.get(i));
        }
    }
    
    // Método para mostrar o produto mais caro
    public static void mostrarProdutoMaisCaro() {
        System.out.println("\n--- PRODUTO MAIS CARO ---");
        
        if (nomesProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }
        
        double maiorPreco = precosProdutos.get(0);
        int indiceMaiorPreco = 0;
        
        // Encontrar o maior preço
        for (int i = 1; i < precosProdutos.size(); i++) {
            if (precosProdutos.get(i) > maiorPreco) {
                maiorPreco = precosProdutos.get(i);
                indiceMaiorPreco = i;
            }
        }
        
        System.out.printf("Produto mais caro: %s%n", nomesProdutos.get(indiceMaiorPreco));
        System.out.printf("Preço: R$ %.2f%n", maiorPreco);
    }
    
    // Método para calcular a média de preços
    public static void calcularMediaPrecos() {
        System.out.println("\n--- MÉDIA DE PREÇOS ---");
        
        if (nomesProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }
        
        double soma = 0;
        for (double preco : precosProdutos) {
            soma += preco;
        }
        
        double media = soma / precosProdutos.size();
        
        System.out.printf("Quantidade de produtos: %d%n", nomesProdutos.size());
        System.out.printf("Soma total dos preços: R$ %.2f%n", soma);
        System.out.printf("Média de preços: R$ %.2f%n", media);
    }
    
    // Método para listar produtos com preço acima da média
    public static void listarProdutosAcimaDaMedia() {
        System.out.println("\n--- PRODUTOS ACIMA DA MÉDIA ---");
        
        if (nomesProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }
        
        // Calcular a média
        double soma = 0;
        for (double preco : precosProdutos) {
            soma += preco;
        }
        double media = soma / precosProdutos.size();
        
        System.out.printf("Média de preços: R$ %.2f%n", media);
        System.out.println("-".repeat(40));
        
        boolean encontrouProdutos = false;
        
        for (int i = 0; i < nomesProdutos.size(); i++) {
            if (precosProdutos.get(i) > media) {
                System.out.printf("%s - R$ %.2f%n", 
                    nomesProdutos.get(i), precosProdutos.get(i));
                encontrouProdutos = true;
            }
        }
        
        if (!encontrouProdutos) {
            System.out.println("Nenhum produto com preço acima da média!");
        }
    }
    
    // DESAFIO EXTRA: Remover produto
    public static void removerProduto() {
        System.out.println("\n--- REMOVER PRODUTO ---");
        
        if (nomesProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }
        
        System.out.print("Digite o nome do produto a ser removido: ");
        String nome = scanner.nextLine().trim();
        
        int indice = -1;
        for (int i = 0; i < nomesProdutos.size(); i++) {
            if (nomesProdutos.get(i).equalsIgnoreCase(nome)) {
                indice = i;
                break;
            }
        }
        
        if (indice != -1) {
            String produtoRemovido = nomesProdutos.get(indice);
            double precoRemovido = precosProdutos.get(indice);
            
            nomesProdutos.remove(indice);
            precosProdutos.remove(indice);
            
            System.out.printf("Produto '%s' (R$ %.2f) removido com sucesso!%n", 
                produtoRemovido, precoRemovido);
        } else {
            System.out.println("Produto não encontrado!");
        }
    }
    
    // DESAFIO EXTRA: Atualizar preço
    public static void atualizarPrecoProduto() {
        System.out.println("\n--- ATUALIZAR PREÇO ---");
        
        if (nomesProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }
        
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine().trim();
        
        int indice = -1;
        for (int i = 0; i < nomesProdutos.size(); i++) {
            if (nomesProdutos.get(i).equalsIgnoreCase(nome)) {
                indice = i;
                break;
            }
        }
        
        if (indice != -1) {
            System.out.printf("Preço atual: R$ %.2f%n", precosProdutos.get(indice));
            System.out.print("Digite o novo preço: R$ ");
            
            try {
                double novoPreco = Double.parseDouble(scanner.nextLine());
                
                if (novoPreco < 0) {
                    System.out.println("Erro: Preço não pode ser negativo!");
                    return;
                }
                
                double precoAntigo = precosProdutos.get(indice);
                precosProdutos.set(indice, novoPreco);
                
                System.out.printf("Preço atualizado com sucesso!%n");
                System.out.printf("Produto: %s%n", nome);
                System.out.printf("Preço anterior: R$ %.2f%n", precoAntigo);
                System.out.printf("Novo preço: R$ %.2f%n", novoPreco);
                
            } catch (NumberFormatException e) {
                System.out.println("Erro: Preço inválido!");
            }
        } else {
            System.out.println("Produto não encontrado!");
        }
    }
    
    // DESAFIO EXTRA: Calcular total do estoque
    public static void calcularTotalEstoque() {
        System.out.println("\n--- TOTAL DO ESTOQUE ---");
        
        if (nomesProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }
        
        double total = 0;
        for (double preco : precosProdutos) {
            total += preco;
        }
        
        System.out.printf("Quantidade de produtos: %d%n", nomesProdutos.size());
        System.out.printf("Valor total do estoque: R$ %.2f%n", total);
        
        // Mostrar estatísticas extras
        double menor = precosProdutos.get(0);
        double maior = precosProdutos.get(0);
        
        for (double preco : precosProdutos) {
            if (preco < menor) menor = preco;
            if (preco > maior) maior = preco;
        }
        
        System.out.printf("Menor preço: R$ %.2f%n", menor);
        System.out.printf("Maior preço: R$ %.2f%n", maior);
        System.out.printf("Preço médio: R$ %.2f%n", total / nomesProdutos.size());
    }
}