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


        }
    }
}