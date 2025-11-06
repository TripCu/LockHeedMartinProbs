import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < testCases; i++) {
            String message = scanner.nextLine();
            System.out.println(decipherMessage(message));
        }
        scanner.close();
    }

    private static String decipherMessage(String message) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (Character.isDigit(ch)) {
            int num = ch - '0';
            if (i + 1 < message.length() && Character.isDigit(message.charAt(i + 1))) {
                num = num * 10 + (message.charAt(++i) - '0');
            }
            if (num >= 1 && num <= 26) {
                result.append((char) ('a' + num - 1));
            }
            } else {
            result.append(ch);
            }
        }
        for (int i = 0; i < result.length(); i++) {
            if (!Character.isLetter(result.charAt(i)) && result.charAt(i) != ' ') {
                result.deleteCharAt(i);
                i--;
            }
        }
        return result.toString();
        
    }
    
}
