import java.util.Scanner;

public class PrimePhoneNumbers {

    private static boolean IDontWantTOSpell(int a, int b, int c) {
        return GreatestCommonDenominator(a, b) == 1 && GreatestCommonDenominator(b, c) == 1 && GreatestCommonDenominator(a, c) == 1;
    }
    private static int GreatestCommonDenominator(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < testCases; i++) {
            String phoneNumber = sc.nextLine();
            String[] parts = phoneNumber.split("[()\\-]");
            int a = Integer.parseInt(parts[1]);
            int b = Integer.parseInt(parts[2]);
            int c = Integer.parseInt(parts[3]);

            if (IDontWantTOSpell(a, b, c)) {
                System.out.println("TRUE");
            } else {
                System.out.println("FALSE");
            }
        }
        sc.close();
    }
}
