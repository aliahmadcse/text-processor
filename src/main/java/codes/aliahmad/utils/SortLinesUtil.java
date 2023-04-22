package codes.aliahmad.utils;

import codes.aliahmad.logger.ConsoleLogger;
import codes.aliahmad.logger.Logger;
import codes.aliahmad.models.Arguments;
import codes.aliahmad.models.SortOrder;
import org.apache.logging.log4j.Level;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.stream.Stream;

public class SortLinesUtil
{
  private static final Logger LOGGER = new ConsoleLogger();

  public static void sort(Arguments arguments)
  {
    Path inputFilePath = Paths.get(arguments.getInputFile());
    validateInputFile(inputFilePath, arguments);

    Path outputFilePath = Paths.get(arguments.getOutputFile());
    validateOutputFile(outputFilePath, arguments);

    try (Stream<String> inputLines = Files.lines(inputFilePath))
    {
      Stream<String> sortedInputLines = sortLinesBasedOnOrder(inputLines, arguments.getSortOrder());
      Files.write(outputFilePath, sortedInputLines.toList());
    }
    catch (IOException ioException)
    {
      LOGGER.log(Level.ERROR, "Issues reading input file");
      throw new RuntimeException("Issues reading input file", ioException);
    }
    LOGGER.log(Level.INFO, "File " + arguments.getInputFile() + " sorted successfully in the "
            + arguments.getSortOrder() + " order");
  }

  private static Stream<String> sortLinesBasedOnOrder(Stream<String> inputLines, SortOrder sortOrder)
  {
    if (sortOrder == SortOrder.ASC)
    {
      return inputLines.sorted();
    }

    return inputLines.sorted(Collections.reverseOrder());
  }

  private static void validateOutputFile(Path outputFilePath, Arguments arguments)
  {
    try
    {
      if (Files.notExists(outputFilePath))
      {
        Files.createFile(outputFilePath);
      }
    }
    catch (IOException ioException)
    {
      LOGGER.log(Level.ERROR, "Error creating output file: " + arguments.getOutputFile());
      throw new RuntimeException("Issues creating a file", ioException);
    }
  }

  private static void validateInputFile(Path inputFilePath, Arguments arguments)
  {
    if (Files.notExists(inputFilePath))
    {
      LOGGER.log(Level.ERROR, arguments.getInputFile() + " file does not exist");
      throw new IllegalArgumentException("input file does not exist");
    }
  }

}
