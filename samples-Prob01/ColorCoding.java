import java.util.Scanner;
public class ColorCoding {
    private static final String[] COLORS = {"red", "blue"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();
        sc.nextLine(); 
        for (int i = 0; i < numTestCases; i++) {
            String lineOfText = sc.nextLine();
            boolean colorFound = false;
            for (String color : COLORS) {
                if (lineOfText.contains(color)) {
                    System.out.println(color);
                    colorFound = true;
                    break;
                }
            }
            if (!colorFound) {
                System.out.println("no color found");
            }
        }
    }
}
