package Completedproblems;
import java.util.*;
public class WeirdAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong(); 
        while (n != 1){
            System.out.print(n + " "); 
            if(n % 2 == 0){
                n = n / 2;
            }
            else{
                n = 3 * n + 1;
            }
        }
        System.out.print(n); 
    }
}
