import java.util.Scanner;

public class GameManager {
    private WordSelector wordSelector;
    private Scanner scanner;
    
    public GameManager() {
        wordSelector = new WordSelector();
        scanner = new Scanner(System.in);
    }
    
    public void startGame() {
        System.out.println("\nSelecione a dificuldade:");
        System.out.println("1. Fácil (4 letras)");
        System.out.println("2. Médio (5 letras)");
        System.out.println("3. Difícil (6 letras)");
        System.out.print("Escolha: ");
        
        int difficulty = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        
        String targetWord = wordSelector.selectWord(difficulty);
        playRound(targetWord);
    }
    
    private void playRound(String targetWord) {
        int attempts = 0;
        boolean guessed = false;
        int wordLength = targetWord.length();
        
        System.out.println("\nTente adivinhar a palavra de " + wordLength + " letras!");
        
        while (!guessed && attempts < 6) {
            System.out.print("Tentativa " + (attempts + 1) + ": ");
            String guess = scanner.nextLine().toLowerCase();
            
            if (guess.length() != wordLength) {
                System.out.println("A palavra deve ter " + wordLength + " letras!");
                continue;
            }
            
            attempts++;
            
            if (guess.equals(targetWord)) {
                guessed = true;
                System.out.println("\nParabéns! Você acertou em " + attempts + " tentativas!");
                RecordsManager.saveRecord(wordLength, attempts);
            } else {
                giveFeedback(targetWord, guess);
            }
        }
        
        if (!guessed) {
            System.out.println("\nVocê perdeu! A palavra era: " + targetWord);
        }
    }
    
    private void giveFeedback(String targetWord, String guess) {
        System.out.print("Feedback: ");
        for (int i = 0; i < targetWord.length(); i++) {
            char gChar = guess.charAt(i);
            char tChar = targetWord.charAt(i);
            
            if (gChar == tChar) {
                System.out.print("[" + gChar + "]"); // Letra correta na posição correta
            } else if (targetWord.contains(String.valueOf(gChar))) {
                System.out.print("(" + gChar + ")"); // Letra correta na posição errada
            } else {
                System.out.print(" " + gChar + " "); // Letra não existe na palavra
            }
        }
        System.out.println();
    }
}
