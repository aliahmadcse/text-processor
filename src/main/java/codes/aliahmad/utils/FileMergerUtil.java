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
import java.util.stream.Stream;

public class FileMergerUtil
{

  private static final Logger LOGGER = new ConsoleLogger();

  public static void mergeFiles(Arguments arguments)
  {
    List<Path> inputFilesPath = new ArrayList<>();

    List<String> inputFiles = arguments.getInputFiles();
    inputFiles.forEach(inputFile -> {
      Path path = Paths.get(inputFile);
      ValidationUtil.validateFile(path, inputFile);
      inputFilesPath.add(path);
    });

    Path outputFilePath = Paths.get(arguments.getOutputFile());

    Stream<String> lines = Stream.empty();

    try
    {
      for (Path path : inputFilesPath)
      {
        lines = Stream.concat(lines, Files.lines(path));
      }

      Files.write(outputFilePath, (Iterable<String>) lines::iterator);
    }
    catch (IOException ioException)
    {
      System.out.println("Issues merging files");
      throw new RuntimeException("Issues merging files: ", ioException);
    }
    LOGGER.log(Level.INFO, "Files merged successfully and saved to " + arguments.getOutputFile());

  }
}
