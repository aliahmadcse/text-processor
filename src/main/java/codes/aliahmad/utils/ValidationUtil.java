package codes.aliahmad.utils;

import codes.aliahmad.logger.ConsoleLogger;
import codes.aliahmad.logger.Logger;
import org.apache.logging.log4j.Level;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ValidationUtil
{
  private static final Logger LOGGER = new ConsoleLogger();

  public static void validateFile(Path path, String fileName)
  {
    if (Files.notExists(path))
    {
      LOGGER.log(Level.ERROR, fileName + " file does not exist");
      throw new IllegalArgumentException("input file " + fileName + " does not exist");
    }
  }

  public static void validateFileOrCreate(Path path, String fileName)
  {
    try
    {
      if (Files.notExists(path))
      {
        Files.createFile(path);
      }
    }
    catch (IOException ioException)
    {
      LOGGER.log(Level.ERROR, "Error creating output file: " + fileName);
      throw new RuntimeException("Issues creating a file", ioException);
    }
  }
}
