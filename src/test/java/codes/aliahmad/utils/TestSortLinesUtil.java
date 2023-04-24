package codes.aliahmad.utils;

import codes.aliahmad.models.Arguments;
import codes.aliahmad.models.Command;
import codes.aliahmad.models.SortOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestSortLinesUtil
{
  private Fixture fixture;

  @BeforeEach
  public void setup()
  {
    fixture = new Fixture();
  }

  @Test
  public void test_sortLinesAsc() throws IOException
  {
    fixture.givenSortArgumentWithAscOrder();
    fixture.whenSortLinesIsInvoked();
    fixture.thenAssertOutputIsSortedAsc();
  }

  @Test
  public void test_sortLinesDesc() throws IOException
  {
    fixture.givenSortArgumentWithDescOrder();
    fixture.whenSortLinesIsInvoked();
    fixture.thenAssertOutputIsSortedDesc();
  }


  private static class Fixture
  {
    private Arguments arguments;
    private static final String INPUT_FILE = "./src/test/resources/input.txt";
    private static final String OUTPUT_FILE = "./src/test/resources/output.txt";
    private static final String OUTPUT_FILE_SORTED_ASC = "./src/test/resources/outputSortedAsc.txt";
    private static final String OUTPUT_FILE_SORTED_DESC = "./src/test/resources/outputSortedDesc.txt";


    public void givenSortArgumentWithAscOrder()
    {
      arguments = new Arguments();
      arguments.setCommand(Command.SORT);
      arguments.setInputFile(INPUT_FILE);
      arguments.setOutputFile(OUTPUT_FILE);
      arguments.setSortOrder(SortOrder.ASC);
    }

    public void whenSortLinesIsInvoked()
    {
      SortLinesUtil.sort(arguments);
    }

    public void thenAssertOutputIsSortedAsc() throws IOException
    {
      String expectedContent = new String(Files.readAllBytes(Paths.get(OUTPUT_FILE_SORTED_ASC)));
      String actualContent = new String(Files.readAllBytes(Paths.get(OUTPUT_FILE)));
      Assertions.assertEquals(expectedContent, actualContent);
    }

    public void givenSortArgumentWithDescOrder()
    {
      arguments = new Arguments();
      arguments.setCommand(Command.SORT);
      arguments.setInputFile(INPUT_FILE);
      arguments.setOutputFile(OUTPUT_FILE);
      arguments.setSortOrder(SortOrder.DESC);
    }

    public void thenAssertOutputIsSortedDesc() throws IOException
    {
      String expectedContent = new String(Files.readAllBytes(Paths.get(OUTPUT_FILE_SORTED_DESC)));
      String actualContent = new String(Files.readAllBytes(Paths.get(OUTPUT_FILE)));
      Assertions.assertEquals(expectedContent, actualContent);
    }

  }
}
