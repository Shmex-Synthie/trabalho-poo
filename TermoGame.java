import java.util.Scanner;

public class TermoGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameManager gameManager = new GameManager();
        
        System.out.println("Bem-vindo ao Jogo Termo!");
        System.out.println("------------------------");
        
        while (true) {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Jogar");
            System.out.println("2. Ver Recordes");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer
            
            switch (choice) {
                case 1:
                    gameManager.startGame();
                    break;
                case 2:
                    RecordsManager.showRecords();
                    break;
                case 3:
                    System.out.println("Obrigado por jogar!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}

