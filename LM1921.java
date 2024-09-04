import java.util.*;

public class LM1921 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a line containing a single integer, N, indicating the number of elements to be added to the webpage.");
        int N = sc.nextInt();

        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        String input = "";

        System.out.println("Enter the two numbers seperated only by a dash, no whitespaces. The first number will be the left offset of an element in pixels. The second number will be the width of that element in pixels.");
        for(int i = 1; i <= N; i++)
        {
            System.out.println("Numbers for line " + i);
            input = sc.next();
            start.add(Integer.parseInt(input.substring(0, input.indexOf("-"))));
            end.add(Integer.parseInt(input.substring(input.indexOf("-") + 1, input.length())) + Integer.parseInt(input.substring(0, input.indexOf("-"))));
        }

        int rows = 1;
        for(int i = 0; i < N; i++)
        {
            for(int x = 0; x < N; x++)
                if(start.get(i) < start.get(x))
                    if(start.get(x) > end.get(i))
                        rows++;
        }
        System.out.println(rows);
    }
}
