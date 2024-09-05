import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class LM1921 
{
    static List<Integer> start;
    static List<Integer> end;
    static List<Integer> height;

    public static void main(String[] args)
    {
        try
        {
            start = new ArrayList<>();
            end = new ArrayList<>();
            height = new ArrayList<>();

            File mytxt = new File("LM1921.txt");
            Scanner sc = new Scanner(mytxt);
            int N = 0;
            String currentLine = "";
            int outerLoop = Integer.parseInt(sc.nextLine());
            for(int q = 0; q <= outerLoop; q++)
            {
                if(sc.hasNextLine())
                {
                    N = Integer.parseInt(sc.nextLine());
            
                    for(int i = 0; i < N; i++)
                    {
                        if(sc.hasNextLine())
                        {
                            currentLine = sc.nextLine();
                            start.add(Integer.parseInt(currentLine.substring(0, currentLine.indexOf(" "))));
                            end.add(start.get(i) + Integer.parseInt(currentLine.substring(currentLine.indexOf(" ") + 1, currentLine.length())));
                            height.add(1);
                        }
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
            }
            sc.close();
        }
        catch (FileNotFoundException  e)
        {
            e.printStackTrace();
        }
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
