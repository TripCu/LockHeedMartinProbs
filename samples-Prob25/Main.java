import java.util.Scanner;

public class Main {
    
    // A small parser to handle +, -, *, /, ^, parentheses, and SQRT().
    // It does floating-point evaluation by default.
    static class ExpressionParser {
        private String s;
        private int pos = -1, ch;

        public ExpressionParser(String s) {
            this.s = s;
            nextChar();
        }

        private void nextChar() {
            pos++;
            ch = (pos < s.length()) ? s.charAt(pos) : -1;
        }

        private boolean eat(int charToEat) {
            while (ch == ' ') nextChar();
            if (ch == charToEat) {
                nextChar();
                return true;
            }
            return false;
        }

        public double parse() {
            double x = parseExpression();
            if (pos < s.length()) {
                throw new RuntimeException("Unexpected: " + (char)ch);
            }
            return x;
        }

        // Grammar: expression = term {('+'|'-') term}
        private double parseExpression() {
            double x = parseTerm();
            while (true) {
                if (eat('+')) {
                    x += parseTerm();
                } else if (eat('-')) {
                    x -= parseTerm();
                } else {
                    return x;
                }
            }
        }

        // term = factor {('*'|'/') factor}
        private double parseTerm() {
            double x = parseFactor();
            while (true) {
                if (eat('*')) {
                    x *= parseFactor();
                } else if (eat('/')) {
                    x /= parseFactor();  // <--- Floating-point division
                } else {
                    return x;
                }
            }
        }

        // factor = primary { '^' factor }
        private double parseFactor() {
            double x = parsePrimary();
            while (eat('^')) {
                x = Math.pow(x, parseFactor());
            }
            return x;
        }

        // primary = number | SQRT(expression) | '(' expression ')' | unary +/- ...
        private double parsePrimary() {
            while (ch == ' ') nextChar();
            if (eat('+')) return parsePrimary();  // unary plus
            if (eat('-')) return -parsePrimary(); // unary minus

            double x;
            int startPos = this.pos;

            if ((ch >= '0' && ch <= '9') || ch == '.') {
                // parse a number
                while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                x = Double.parseDouble(s.substring(startPos, this.pos));
            } else if (Character.isLetter(ch)) {
                // parse function (like SQRT)
                while (Character.isLetter(ch)) nextChar();
                String func = s.substring(startPos, this.pos);
                if (eat('(')) {
                    x = parseExpression();
                    if (!eat(')')) {
                        throw new RuntimeException("Missing ')' after argument to " + func);
                    }
                } else {
                    throw new RuntimeException("Function " + func + " missing parentheses");
                }
                if (func.equalsIgnoreCase("SQRT")) {
                    x = Math.sqrt(x);
                } else {
                    throw new RuntimeException("Unknown function: " + func);
                }
            } else if (eat('(')) {
                x = parseExpression();
                if (!eat(')')) throw new RuntimeException("Missing ')'");
            } else {
                throw new RuntimeException("Unexpected character: " + (char)ch);
            }
            return x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read lines until EOF
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                // Skip empty lines if any
                continue;
            }
            // Split at '='
            String[] parts = line.split("=");
            if (parts.length != 2) {
                // If format is invalid, skip or handle differently
                // But typically you'd want to do exactly what's required by your problem
                continue;
            }

            String expression = parts[0].trim();
            String studentAnsStr = parts[1].trim();

            // Convert student answer to double
            double studentAnswer;
            try {
                studentAnswer = Double.parseDouble(studentAnsStr);
            } catch (NumberFormatException e) {
                // Not a valid number
                // Decide what to do; maybe skip or print an error
                continue;
            }

            // Evaluate expression
            double result;
            try {
                ExpressionParser parser = new ExpressionParser(expression);
                result = parser.parse();
            } catch (Exception e) {
                // Expression could not be parsed or had an error
                // Decide how your problem wants you to handle that
                continue;
            }

            // Compare with a tolerance of 1e-3
            if (Math.abs(result - studentAnswer) < 1e-3) {
                System.out.println("Correct");
            } else {
                // If the result is effectively an integer, print it as an int
                if (Math.abs(result - Math.round(result)) < 1e-3) {
                    System.out.println((int)Math.round(result));
                } else {
                    // Otherwise, print with 3 decimals
                    System.out.printf("%.3f%n", result);
                }
            }
        }
        
        sc.close();
    }
}
