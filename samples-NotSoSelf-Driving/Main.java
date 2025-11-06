import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            String input = sc.nextLine();
            if (!input.startsWith("v")) {
                System.out.println("Invalid input: " + input);
                continue;
            }
            String[] parts = input.split(":");
            double currentSpeed = Double.parseDouble(parts[1]);
            double obstacleDistance = Double.parseDouble(parts[2]);
            if (currentSpeed <= 0 || obstacleDistance <= 0) {
                System.out.println("Invalid input: " + input);
                continue;
            }
            double timeToCollision = calculateTimeToCollision(currentSpeed, obstacleDistance);
            if (timeToCollision <= 1) {
                System.out.println("SWERVE");
            } else if (timeToCollision <= 5) {
                System.out.println("BRAKE");
            } else {
                System.out.println("SAFE");
            }
        }
    }

    private static double calculateTimeToCollision(double currentSpeed, 
double obstacleDistance) {
        return obstacleDistance / currentSpeed;
    }
}