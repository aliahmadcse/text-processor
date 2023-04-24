package codes.aliahmad.utils;

import codes.aliahmad.models.Arguments;
import codes.aliahmad.models.Command;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestReplaceTextUtil
{
  private Fixture fixture;

  @BeforeEach
  public void setup()
  {
    fixture = new Fixture();
  }

  @Test
  public void test_replaceText() throws IOException
  {
    fixture.givenReplaceArgument();
    fixture.whenReplaceMethodIsInvoked();
    fixture.thenAssertOutputIsReplaced();
  }


  private static class Fixture
  {
    private Arguments arguments;
    private static final String INPUT_FILE = "./src/test/resources/input.txt";
    private static final String OUTPUT_FILE = "./src/test/resources/output.txt";
    private static final String OUTPUT_FILE_TEXT_REPLACED = "./src/test/resources/outputReplaced.txt";


    public void givenReplaceArgument()
    {
      arguments = new Arguments();
      arguments.setCommand(Command.REPLACE);
      arguments.setInputFile(INPUT_FILE);
      arguments.setOutputFile(OUTPUT_FILE);
      arguments.setSearchText("fox");
      arguments.setReplaceText("cat");
    }

    public void whenReplaceMethodIsInvoked()
    {
      ReplaceTextUtil.replace(arguments);
    }

    public void thenAssertOutputIsReplaced() throws IOException
    {
      String expectedContent = new String(Files.readAllBytes(Paths.get(OUTPUT_FILE_TEXT_REPLACED)));
      String actualContent = new String(Files.readAllBytes(Paths.get(OUTPUT_FILE)));
      Assertions.assertEquals(expectedContent, actualContent);
    }

  }

}
