import java.util.Scanner;

public class IncomeTaxCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numCases = scanner.nextInt();
        int[] incomes = new int[numCases];
        
        for (int i = 0; i < numCases; i++) {
            incomes[i] = scanner.nextInt();
        }
        
        for (int income : incomes) {
            System.out.println(calculateTax(income));
        }
        
        scanner.close();
    }

    public static int calculateTax(int income) {
        int[][] brackets = {
            {11000, 10},
            {44725, 12},
            {95375, 22},
            {182100, 24},
            {231250, 32},
            {578125, 35},
            {Integer.MAX_VALUE, 37}
        };
        
        int previousLimit = 0;
        double tax = 0.0;
        
        for (int[] bracket : brackets) {
            int limit = bracket[0];
            int rate = bracket[1];
            
            if (income > limit) {
                tax += (limit - previousLimit) * (rate / 100.0);
                previousLimit = limit;
            } else {
                tax += (income - previousLimit) * (rate / 100.0);
                break;
            }
        }
        
        return (int) Math.round(tax);
    }
}