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
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class DeDupUtil
{
  private static final Logger LOGGER = new ConsoleLogger();

  public static void removeDuplicateLines(Arguments arguments)
  {
    Path path = Paths.get(arguments.getInputFile());
    ValidationUtil.validateFile(path, arguments.getInputFile());

    Path outputFilePath = Paths.get(arguments.getOutputFile());
    ValidationUtil.validateFileOrCreate(outputFilePath, arguments.getOutputFile());

    Set<String> uniqueLines = new LinkedHashSet<>();

    try (Stream<String> inputLines = Files.lines(path))
    {
      inputLines.forEach(uniqueLines::add);
      Files.write(outputFilePath, uniqueLines);
    }
    catch (IOException ioException)
    {
      LOGGER.log(Level.ERROR, "Having issues reading a file");
      throw new RuntimeException("Having issues reading a file", ioException);
    }
    LOGGER.log(Level.INFO, "File " + arguments.getInputFile() + " de-duped successfully and saved to "
            + arguments.getOutputFile());
  }


}
