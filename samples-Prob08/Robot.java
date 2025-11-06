import java.util.Scanner;

public class Robot {
    private static char tR(char direction) {
        switch (direction) {
            case 'N':
                return 'E';
            case 'E':
                return 'S';
            case 'S':
                return 'W';
            case 'W':
                return 'N';
            default:
                return direction;
        }
    }

    private static char tL(char direction) {
        switch (direction) {
            case 'N':
                return 'W';
            case 'W':
                return 'S';
            case 'S':
                return 'E';
            case 'E':
                return 'N';
            default:
                return direction;
        }
    }

    private static int[] move(int x, int y, char direction) {
        switch (direction) {
            case 'N':
                y += 1;
                break;
            case 'E':
                x += 1;
                break;
            case 'S':
                y -= 1;
                break;
            case 'W':
                x -= 1;
                break;
        }
        return new int[]{x, y};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            char direction = sc.next().charAt(0);
            String commands = sc.next();

            for (char command : commands.toCharArray()) {
                switch (command) {
                    case 'R':
                        direction = tR(direction);
                        break;
                    case 'L':
                        direction = tL(direction);
                        break;
                    case 'A':
                        int[] newPosition = move(x, y, direction);
                        x = newPosition[0];
                        y = newPosition[1];
                        break;
                }
            }
            System.out.println(x + " " + y + " " + direction);
        }
        sc.close();
    }
}