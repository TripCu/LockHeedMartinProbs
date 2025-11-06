import java.util.Scanner;

public class CollisionFlare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            
            double v1 = Double.parseDouble(parts[0]);
            double m1 = Double.parseDouble(parts[1]);
            double vz = Double.parseDouble(parts[2]); 
            double m2 = Double.parseDouble(parts[3]);
            
            double numerator = m1 * v1 + m2 * vz;
            double denominator = m1 + m2;
            
            if (denominator == 0) {
                System.out.println("inf");
                continue;
            }
            
            double velocity = numerator / denominator;
            
            String formattedVelocity = String.format("%.2f", velocity);
            System.out.println(formattedVelocity);
        }
    }
}
