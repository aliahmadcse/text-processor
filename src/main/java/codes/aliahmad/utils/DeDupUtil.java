package codes.aliahmad.utils;

import codes.aliahmad.models.Arguments;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeDupUtil
{

  public static void removeDuplicateLines(Arguments arguments)
  {
    Path path = Paths.get("codes/aliahmad/main/resources/input.txt");
    Set<String> uniqueLiens = new HashSet<>();
    Charset standardCharSet = StandardCharsets.UTF_8;

    try
    {
      Files.lines(path).forEach(uniqueLiens::add);
      Files.write(path, List.of(""), standardCharSet);
      Files.write(path, uniqueLiens, standardCharSet);
    }
    catch (IOException ioException)
    {
      System.out.println("Having issues reading a file");
      ioException.printStackTrace();
    }
    uniqueLiens.forEach(System.out::println);


  }


}
