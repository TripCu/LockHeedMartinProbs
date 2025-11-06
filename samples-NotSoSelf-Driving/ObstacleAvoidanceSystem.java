import java.util.Scanner;

public class ObstacleAvoidanceSystem {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numTestCases = scanner.nextInt();
    for (int i = 0; i < numTestCases; i++) {
      double V = scanner.nextDouble();
      double X = scanner.nextDouble();
      String output = getInstructions(V, X);
      System.out.println(output);
    }
  }

  private static String getInstructions(double V, double X) {
    if (isCollisionImminent(V, X)) {
      return "SWERVE";
    } else if (isDangerous(V, X)) {
      return "BRAKE";
    } else {
      return "SAFE";
    }
  }

  private static boolean isCollisionImminent(double V, double X) {
    double brakingDistance = calculateBrakingDistance(V);
    return (X < brakingDistance);
  }

  private static boolean isDangerous(double V, double X) {
    double fiveSecondsInMeters = 5.0 * V;
    return (X < fiveSecondsInMeters);
  }

  private static double calculateBrakingDistance(double V) {
    // Coefficient of friction between tires and road is 0.1
    return Math.sqrt(V * V * 0.1);
  }
}
