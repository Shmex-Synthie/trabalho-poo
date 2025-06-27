import java.io.*;
import java.util.*;

public class RecordsManager {
    private static final String RECORDS_FILE = "records.txt";
    
    public static void saveRecord(int wordLength, int attempts) {
        try {
            File file = new File(RECORDS_FILE);
            if (!file.exists()) {
                file.createNewFile();
            }
            
            List<String> lines = new ArrayList<>();
            if (file.length() > 0) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        lines.add(line);
                    }
                }
            }
            
            boolean updated = false;
            for (int i = 0; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(":");
                if (parts[0].equals(String.valueOf(wordLength))) {
                    int currentRecord = Integer.parseInt(parts[1]);
                    if (attempts < currentRecord) {
                        lines.set(i, wordLength + ":" + attempts);
                        updated = true;
                    }
                    break;
                }
            }
            
            if (!updated) {
                lines.add(wordLength + ":" + attempts);
            }
            
            try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                for (String line : lines) {
                    writer.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar recorde: " + e.getMessage());
        }
    }
    
    public static void showRecords() {
        try {
            File file = new File(RECORDS_FILE);
            if (!file.exists() || file.length() == 0) {
                System.out.println("\nNenhum recorde registrado ainda!");
                return;
            }
            
            System.out.println("\nRecordes:");
            System.out.println("---------");
            
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(":");
                    System.out.println("Palavras de " + parts[0] + " letras: " + parts[1] + " tentativas");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler recordes: " + e.getMessage());
        }
    }
}
