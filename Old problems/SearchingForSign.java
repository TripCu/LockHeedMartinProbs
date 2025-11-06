import java.util.*;

public class SearchingForSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < testCases; t++) {
            int R = Integer.parseInt(scanner.nextLine());
            StringBuilder referenceText = new StringBuilder();
            
            for (int i = 0; i < R; i++) {
                referenceText.append(scanner.nextLine()).append(" ");
            }
            
            String keyword = scanner.nextLine().toLowerCase();
            
            processText(referenceText.toString(), keyword);
        }
        
        scanner.close();
    }
    
    public static void processText(String text, String keyword) {
        String[] sentences = text.split("(?<=[.!?])\\s+"); 
        
        for (String sentence : sentences) {
            String[] words = sentence.split(" ");
            List<String> cleanWords = new ArrayList<>();
            
            for (String word : words) {
                cleanWords.add(word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase());
            }

            for (String word : words) {
                cleanWords.add(word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase());
            }
            for (int i = 0; i < cleanWords.size(); i++) {
                if (cleanWords.get(i).equals(keyword)) {
                    int start = Math.max(0, i - 3);
                    int end = Math.min(words.length, i + 6);
                    
                    StringBuilder snippet = new StringBuilder();
                    
                    if (start > 0) snippet.append("...");
                    
                    for (int j = start; j < end; j++) {
                        if (j == i) snippet.append("*").append(words[j]).append("*");
                        else snippet.append(words[j]);
                        if (j < end - 1) snippet.append(" ");
                    }
                    
                    if (end < words.length) snippet.append("...");
                    
                    System.out.println(snippet.toString());
                }
            }
        }
    }
}
