import java.util.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); 
        
        for (int i = 0; i < t; i++) {
            String line = sc.nextLine().trim();
            String combined = line.replaceAll("\\s+", "");
            
            int p1Max = getMax(combined.substring(0, 3));
            int p2Max = getMax(combined.substring(3, 6));
            
            if (p1Max > p2Max) {
                System.out.println("PLAYER 1");
            } else if (p2Max > p1Max) {
                System.out.println("PLAYER 2");
            } else {
                System.out.println("WAR!");
            }
        }
        sc.close();
    }
    private static int getMax(String cards) {
        int[] digits = new int[3];
        for (int i = 0; i < 3; i++) {
            digits[i] = cards.charAt(i) - '0';
        }
        Arrays.sort(digits); 
        return digits[2] * 10 + digits[1];
    }
}
