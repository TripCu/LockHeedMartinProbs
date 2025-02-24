import java.util.*;

public class WhichIsLarger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Number of test cases
        int T = Integer.parseInt(sc.nextLine().trim());
        
        while (T-- > 0) {
            // Read one entire test case line (e.g., "8 7 6 415")
            String line = sc.nextLine().trim();
            
            // Split into individual number strings
            String[] numbers = line.split("\\s+");
            
            // Sort the numbers using a custom comparator
            // Compare (s2 + s1) with (s1 + s2) to ensure descending order
            Arrays.sort(numbers, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
            
            // Concatenate all numbers in sorted order
            StringBuilder sb = new StringBuilder();
            for (String num : numbers) {
                sb.append(num);
            }
            
            // Print the largest concatenated number
            System.out.println(sb.toString());
        }
        
        sc.close();
    }
}
