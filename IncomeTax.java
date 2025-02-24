import java.util.Scanner;

public class IncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of test cases
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            // Read the income
            int income = sc.nextInt();

            // Compute the tax
            int tax = computeTax(income);

            // Print the result for this test case
            System.out.println(tax);
        }

        sc.close();
    }

    // Helper method to determine the tax based on the problem's brackets
    private static int computeTax(int income) {
        double rate;
        if (income < 10000) {
            rate = 0.10; // 10%
        } else if (income <= 20000) {
            rate = 0.15; // 15%
        } else if (income <= 44725) {
            rate = 0.20; // 20%
        } else if (income <= 98316) {
            rate = 0.25; // 25%
        } else if (income <= 213251) {
            rate = 0.30; // 30%
        } else if (income <= 241000) {
            rate = 0.35; // 35%
        } else {
            rate = 0.37; // 37%
        }

        // Calculate tax = income * rate; round to nearest integer
        double taxAmount = income * rate;
        return (int)Math.round(taxAmount);
    }
}
