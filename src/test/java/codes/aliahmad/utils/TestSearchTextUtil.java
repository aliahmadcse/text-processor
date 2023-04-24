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
import java.util.ArrayList;
import java.util.List;

public class TestSearchTextUtil
{

  private Fixture fixture;

  @BeforeEach
  public void setup()
  {
    fixture = new Fixture();
  }

  @Test
  public void test_searchText()
  {
    fixture.givenSearchArguments();
    fixture.whenSearchIsInvoked();
    fixture.thenAssertSearchLineNumberAreValid();
  }

  private static class Fixture
  {
    private Arguments arguments;
    List<Integer> actualLineNumbers;
    private static final String INPUT_FILE = "./src/test/resources/input.txt";

    public void givenSearchArguments()
    {
      arguments = new Arguments();
      arguments.setCommand(Command.SEARCH);
      arguments.setInputFile(INPUT_FILE);
      arguments.setSearchText("fox");
    }

    public void whenSearchIsInvoked()
    {
      this.actualLineNumbers = SearchTextUtil.search(arguments);
    }

    public void thenAssertSearchLineNumberAreValid()
    {
      List<Integer> expectedLineNumbers = List.of(4);
      Assertions.assertEquals(expectedLineNumbers.size(), actualLineNumbers.size());
      Assertions.assertEquals(expectedLineNumbers, actualLineNumbers);
    }
  }
}
