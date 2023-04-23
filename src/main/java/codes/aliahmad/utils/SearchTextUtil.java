package codes.aliahmad.utils;

import codes.aliahmad.logger.ConsoleLogger;
import codes.aliahmad.logger.Logger;
import codes.aliahmad.models.Arguments;
import org.apache.logging.log4j.Level;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SearchTextUtil
{
  private static final Logger LOGGER = new ConsoleLogger();

  public static void search(Arguments arguments)
  {
    Path path = Paths.get(arguments.getInputFile());
    ValidationUtil.validateFile(path, arguments.getInputFile());

    List<Integer> lineNumbers = new ArrayList<>();

    try
    {
      List<String> lines = Files.readAllLines(path);

      for (int i = 0; i < lines.size(); i++)
      {
        if (lines.get(i).toLowerCase().contains(arguments.getSearchText().toLowerCase()))
        {
          lineNumbers.add(i + 1);
        }
      }

    }
    catch (IOException ioException)
    {
      System.out.println("Error reading files");
      throw new RuntimeException("Error reading files", ioException);
    }

    LOGGER.log(Level.INFO, "The text " + arguments.getSearchText() +
            " was found in the following lines: " + lineNumbers);
  }
}
