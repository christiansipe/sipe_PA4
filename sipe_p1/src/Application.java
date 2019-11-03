import java.io.*;
import java.util.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Application
{
    public static void main(String[] args)
    {
        DuplicateRemover rmvr = new DuplicateRemover();

        try
        {
            rmvr.remove("problem1.txt");
            rmvr.write("unique_words.txt");
        }
        catch (IOException e)
        {
            System.out.println("IOException / Error.");
        }
    }
}

class DuplicateRemover
{
    Set<String> uniqueWords = new HashSet<>();

    void remove(String dataFile) throws IOException
    {
        File file = new File(dataFile);

        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
        {
            uniqueWords.add(sc.nextLine());
        }

    }

    void write(String outputFile) throws IOException
    {
        Writer wr = new FileWriter(outputFile);

        for (String uniqueWord : uniqueWords)
        {
            wr.write(uniqueWord + "\n");
        }

        wr.flush();
        wr.close();
    }
}