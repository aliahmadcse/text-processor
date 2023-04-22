package codes.aliahmad.utils;

import codes.aliahmad.models.Arguments;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReplaceTextUtil
{

  public static boolean replace(Arguments arguments)
  {
    Path path = Paths.get("codes/aliahmad/main/resources/input.txt");
    Charset charset = StandardCharsets.UTF_8;
    try
    {
      String content = new String(Files.readAllBytes(path));
      content = content.replaceAll(arguments.getSearchText(), arguments.getReplaceText());
      Files.writeString(path, content, charset);
    }
    catch (IOException ioException)
    {
      System.out.println("Error reading files");
      ioException.printStackTrace();
    }
    return true;

  }
}
