import java.util.*;

public class NotSoSelfDriving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        
        for (int i = 0; i < testCases; i++) {
            String[] input = scanner.nextLine().split(":");
            double V = Double.parseDouble(input[0]);
            double X = Double.parseDouble(input[1]);
            
            if (V == 0) {
                System.out.println("SAFE"); // If speed is zero, no collision
                continue;
            }
            
            double timeToCollision = X / V;
            
            if (timeToCollision <= 1) {
                System.out.println("SWERVE");
            } else if (timeToCollision <= 5) {
                System.out.println("BRAKE");
            } else {
                System.out.println("SAFE");
            }
        }
        
        scanner.close();
    }
}
