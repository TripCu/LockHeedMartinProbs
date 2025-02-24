import java.util.*;

public class WhichIsLarger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = Integer.parseInt(sc.nextLine().trim());
        
        while (T-- > 0) {
            String line = sc.nextLine().trim();
            
            String[] numbers = line.split("\\s+");
            

            Arrays.sort(numbers, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
            
            StringBuilder sb = new StringBuilder();
            for (String num : numbers) {
                sb.append(num);
            }
            
            System.out.println(sb.toString());
        }
        
        sc.close();
    }
}
