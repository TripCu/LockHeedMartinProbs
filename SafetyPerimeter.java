import java.util.Scanner;

public class SafetyPerimeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of test cases
        int T = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        for (int t = 0; t < T; t++) {
            // Read the number of points along the path
            int N = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            // Read the line of N "x,y" pairs, split by space
            String[] coordinatePairs = sc.nextLine().split(" ");

            // Parse the N points
            int[] xPoints = new int[N];
            int[] yPoints = new int[N];
            for (int i = 0; i < N; i++) {
                String[] xy = coordinatePairs[i].split(",");
                xPoints[i] = Integer.parseInt(xy[0]);
                yPoints[i] = Integer.parseInt(xy[1]);
            }

            // Read the robot's coordinates
            int robotX = sc.nextInt();
            int robotY = sc.nextInt();

            // Read the minimum safe distance
            int safeDistance = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            // Check each point's distance to the robot
            boolean allSafe = true;
            for (int i = 0; i < N; i++) {
                double dist = Math.sqrt(
                    Math.pow(xPoints[i] - robotX, 2) + 
                    Math.pow(yPoints[i] - robotY, 2)
                );

                if (dist < safeDistance) {
                    // This point is too close; path is unsafe
                    allSafe = false;
                    break;
                }
            }

            // Print result for this test case
            if (allSafe) {
                System.out.println("SAFE");
            } else {
                System.out.println("NOT SAFE");
            }
        }

        sc.close();
    }
}
