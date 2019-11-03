import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application
{
    public static void main(String[] args)
    {
        DuplicateCounter counter = new DuplicateCounter();

        try
        {
            counter.count("problem2.txt");
            counter.write("unique_word_counts.txt");
        }
        catch (IOException e)
        {
            System.out.println("IOException / Error.");
        }
    }
}

class DuplicateCounter
{
    HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();

    void count(String dataFile) throws IOException
    {
        File file = new File(dataFile);
        Scanner scnr = new Scanner(file);
        String temp;

        while (scnr.hasNextLine())
        {
            temp = scnr.nextLine();
            if (wordCounter.containsKey(temp))
            {
                wordCounter.put(temp, wordCounter.get(temp) + 1);
            }
            else
            {
                wordCounter.put(temp, 1);
            }
        }
    }

    void write(String outputFile) throws IOException
    {
        Writer wr = new FileWriter(outputFile);

        for (Map.Entry<String, Integer> entry : wordCounter.entrySet())
        {
            wr.write(entry.getKey() + ": " + entry.getValue().toString() + "\n");
        }

        wr.flush();
        wr.close();
    }
}