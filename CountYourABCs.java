import java.util.*;

public class CountYourABCs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        scanner.nextLine(); 

        for (int t = 0; t < testCases; t++) {
            String line = scanner.nextLine();

            int[] letterCounts = new int[26];

            for (char c : line.toCharArray()) {
                if (Character.isLetter(c)) {
                    letterCounts[c - 'A']++;
                }
            }

            int maxCount = 0;
            for (int count : letterCounts) {
                if (count > maxCount) {
                    maxCount = count;
                }
            }

            System.out.println(maxCount);
        }
        
        scanner.close();
    }
}
