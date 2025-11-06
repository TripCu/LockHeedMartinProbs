import java.util.Scanner;
public class FlexTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 0; i < testCases; i++) {
            int projects = sc.nextInt();
            int totalHours = 0;
            for (int j = 0; j < projects; j++) {
                for (int k = 0; k < 7; k++) {
                    totalHours += sc.nextInt();
                }
            }
            int difference = totalHours - 40;
            System.out.println(difference);
        }
        sc.close();
    }
}