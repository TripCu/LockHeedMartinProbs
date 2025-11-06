import java.util.Scanner;

public class LostinTrans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < testCases; i++) {
            String hs = sc.nextLine();
            StringBuilder ds = new StringBuilder();
            String[] hv = hs.split(" ");

            for (String hex : hv) {
                int decimal = Integer.parseInt(hex, 16);
                ds.append((char) decimal);
            }

            boolean isValid = true;
            for (char c : ds.toString().toCharArray()) {
                if (!(Character.isLetterOrDigit(c) || c == ' ' || c == '.' || c == ',' || c == '[' || c == ']' || c == ':')) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println("VALID");
            } else {
                System.out.println("INVALID");
            }
        }
        sc.close();
    }
}
