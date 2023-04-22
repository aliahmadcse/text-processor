package codes.aliahmad.utils;

import codes.aliahmad.models.Arguments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SearchTextUtil
{

  public static List<Integer> search(Arguments arguments)
  {

    Path path = Paths.get("codes/aliahmad/main/resources/input.txt");
    List<Integer> lineNumbers = new ArrayList<>();

    try
    {

      String filesContext = new String(Files.readAllBytes(path));
      String[] lines = filesContext.split("\\r?\\n");

      for (int i = 0; i < lines.length; i++)
      {
        if (lines[i].equals(arguments.getSearchText()))
        {
          lineNumbers.add(i + 1);
        }
      }

    }
    catch (IOException ioException)
    {
      System.out.println("Error reading files");
      ioException.printStackTrace();
    }
    return lineNumbers;
  }
}
