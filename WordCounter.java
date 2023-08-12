import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to Word Counter!");
            System.out.print("Enter a text or provide a file path: ");
            String input = scanner.nextLine();
            
            String content = "";
            try {
                if (input.contains(".txt")) {
                    content = readFile(input);
                } else {
                    content = input;
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
                return;
            }
            
            String[] words = content.split("[\\s\\p{Punct}]+");
            int wordCount = words.length;
            
            System.out.println("Total word count: " + wordCount);
        }
    }
    
    private static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append("\n");
            }
        }
        return content.toString();
    }
}
