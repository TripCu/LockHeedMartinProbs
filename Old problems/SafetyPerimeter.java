import java.util.Scanner;

public class SafetyPerimeter1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int testCase = 0; testCase < t; testCase++) {
            int N = scanner.nextInt();
            int robotX = scanner.nextInt();
            int robotY = scanner.nextInt();
            int minSafe = scanner.nextInt();
            int safeSq = minSafe * minSafe;
            for (int i = 0; i < N; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int dx = robotX - x;
                int dy = robotY - y;
                if (dx * dx + dy * dy >= safeSq) {
                    System.out.println("SAFE");
                } else {
                    System.out.println("DANGER");
                }
            }
        }
    }
}
