package codes.aliahmad.utils;

import codes.aliahmad.models.Arguments;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileMergerUtil
{

  public static void mergeFiles(Arguments arguments)
  {
    Path filePath1 = Paths.get("codes/aliahmad/main/resources/input.txt");
    Path filePath2 = Paths.get("codes/aliahmad/main/resources/input2.txt");
    Path outPutPath = Paths.get("codes/aliahmad/main/resources/output.txt");
    Charset charset = StandardCharsets.UTF_8;

    try
    {
      Stream<String> lines1 = Files.lines(filePath1, charset);
      Stream<String> lines2 = Files.lines(filePath2, charset);
      Files.write(outPutPath, (Iterable<String>) lines1::iterator);
      Files.write(outPutPath, (Iterable<String>) lines2::iterator);
    }
    catch (IOException ioException)
    {
      System.out.println("Issues reading a file");
      ioException.printStackTrace();
    }
  }
}
