import java.util.*;

public class LM1921 
{
    static List<Integer> start = new ArrayList<>();
    static List<Integer> end = new ArrayList<>();
    static List<String> name = new ArrayList<>();
    static List<Integer> height = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a line containing a single integer, N, indicating the number of elements to be added to the webpage.");
        int N = sc.nextInt();

        String input = "";

        System.out.println("Enter the two numbers seperated only by a dash, no whitespaces. The first number will be the left offset of an element in pixels. The second number will be the width of that element in pixels.");
        for(int i = 1; i <= N; i++)
        {
            System.out.println("Numbers for line " + i);
            input = sc.next();
            start.add(Integer.parseInt(input.substring(0, input.indexOf("-"))));
            end.add(Integer.parseInt(input.substring(input.indexOf("-") + 1, input.length())) + Integer.parseInt(input.substring(0, input.indexOf("-"))));
            name.add(input);
            height.add(1);
        }

        int totalRows = 1;
        for(int i = 0; i < N; i++) //Runs for each individual rectangle (0 -> N)
            for(int currentRow = 0; currentRow <= totalRows; currentRow++) //Checks each created row (row 0 -> quantity of created lines with a minimum of 1)
            {
                List<Integer> positions = findMe(height.get(i)); //Returns positions of all rects on current row IN THE ARRAY
                for(int pos : positions)
                    //Checks to see if the left side of rectangle i is in another rectangle
                    if(start.get(i) > start.get(pos)) //Translated to human: if the left side of the rectangle is to the right of the left side of any other rectangles on that row, continue down
                        if(start.get(i) < end.get(pos)) //Translated to human: if the left side of the rectangle is to the left of the right side of the previous rectangle, continue down
                        {
                            height.set(pos, height.get(pos) + 1);
                            if(totalRows < height.get(pos))
                                totalRows++;
                            break;
                        }
            }
        System.out.println(totalRows);
    }

    public static List<Integer> findMe(int lookOn)
    {
        List<Integer> returnList = new ArrayList<>();
        int c = 0;
        for(int rowNumber : height)
        {
            if(lookOn == rowNumber)
                returnList.add(c);
            c++;
        }
        return returnList;
    }
}
