package codes.aliahmad.utils;

import codes.aliahmad.logger.ConsoleLogger;
import codes.aliahmad.logger.Logger;
import codes.aliahmad.models.Arguments;
import org.apache.logging.log4j.Level;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReplaceTextUtil
{
  private static final Logger LOGGER = new ConsoleLogger();

  public static void replace(Arguments arguments)
  {
    Path path = Paths.get(arguments.getInputFile());
    ValidationUtil.validateFile(path, arguments.getInputFile());

    Path outputFilePath = Paths.get(arguments.getOutputFile());
    ValidationUtil.validateFileOrCreate(outputFilePath, arguments.getOutputFile());

    try (Stream<String> inputLines = Files.lines(path))
    {
      Stream<String> replacedLines = inputLines.map(line -> line.replaceAll(arguments.getSearchText(), arguments.getReplaceText()));
      Files.write(outputFilePath, replacedLines.toList());
    }
    catch (IOException ioException)
    {
      System.out.println("Error reading files");
      throw new RuntimeException("Error reading files", ioException);
    }

    LOGGER.log(Level.INFO, "File " + arguments.getInputFile() + " replaced successfully and saved to "
            + arguments.getOutputFile());
  }
}
