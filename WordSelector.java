import java.util.Random;

public class WordSelector {
    private String[][] words = {
        // Palavras fáceis (4 letras)
        {"luta", "vela", "ruas", "fita", "casa", "vida", "piso", "bolo", "gato", "leão", "roda", "fogo", "teto", "pena", "muro"},
        // Palavras médias (5 letras)
        {"livro", "campo", "vento", "bravo", "praia", "risco", "folha", "troca", "canto", "forca", "cervo", "amigo", "banco", "cobra", "navio"},
        // Palavras difíceis (6 letras)
        {"escola", "mestre", "folhas", "coruja", "limite", "pintor", "rodado", "garoto", "pratos", "fecham", "caneta", "janela", "colina", "tomate", "castro"}
    };
    
    private Random random;
    
    public WordSelector() {
        random = new Random();
    }
    
    public String selectWord(int difficulty) {
        int index = difficulty - 1;
        if (index < 0 || index >= words.length) {
            index = 1; // Padrão para médio
        }
        
        String[] selectedWords = words[index];
        return selectedWords[random.nextInt(selectedWords.length)];
    }
}
