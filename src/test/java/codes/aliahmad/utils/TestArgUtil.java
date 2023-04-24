package codes.aliahmad.utils;

import codes.aliahmad.models.Arguments;
import codes.aliahmad.models.Command;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestArgUtil
{
  private Fixture fixture;

  @BeforeEach
  public void setup()
  {
    fixture = new Fixture();
  }

  @Test
  public void test_parsingSortArgs()
  {
    fixture.givenArguments(new String[]{"sort", "--input-file", "input.txt", "--output-file",
            "output.txt", "--order", "asc"});
    fixture.whenArgumentsAreParsed();
    fixture.thenCommandIsSort();
    fixture.thenInputFileIs("input.txt");
    fixture.thenOutputFileIs("output.txt");
    fixture.thenSortOrderIsAsc();
  }

  @Test
  public void test_parsingSearchArgs()
  {
    fixture.givenArguments(new String[]{"search", "--search-text", "search text", "--input-file",
            "input.txt", "--output-file", "output.txt"});
    fixture.whenArgumentsAreParsed();
    fixture.thenCommandIsSearch();
    fixture.thenInputFileIs("input.txt");
    fixture.thenSearchTextIs("search text");
    fixture.thenOutputFileIsNull();
  }

  @Test
  public void test_parsingMergeArgs()
  {
    fixture.givenArguments(new String[]{"merge", "--input-files", "input1.txt", "input2.txt", "input3.txt",
            "--output-file", "output.txt"});
    fixture.whenArgumentsAreParsed();
    fixture.thenCommandIsMerge();
    fixture.thenInputFilesAre(List.of("input1.txt", "input2.txt", "input3.txt"));
    fixture.thenOutputFileIs("output.txt");
  }

  @Test
  public void test_parsingReplaceArgs()
  {
    fixture.givenArguments(new String[]{"replace", "--search-text", "search text", "--input-file", "input.txt",
            "--output-file", "output.txt", "--replace-text", "replace text"});
    fixture.whenArgumentsAreParsed();
    fixture.thenCommandIsReplace();
    fixture.thenInputFileIs("input.txt");
    fixture.thenSearchTextIs("search text");
    fixture.thenReplaceTextIs("replace text");
    fixture.thenOutputFileIs("output.txt");
  }

  @Test
  public void test_parsingDedupArgs()
  {
    fixture.givenArguments(new String[]{"dedup", "--output-file", "output.txt", "--input-file", "input.txt"});
    fixture.whenArgumentsAreParsed();
    fixture.thenCommandIsDedup();
    fixture.thenInputFileIs("input.txt");
    fixture.thenOutputFileIs("output.txt");
  }

  private static class Fixture
  {
    private String[] args;

    Arguments arguments;

    public void givenArguments(String[] args)
    {
      this.args = args;
    }

    public void whenArgumentsAreParsed()
    {
      arguments = new ArgUtil().parseArguments(args);
    }

    public void thenCommandIsSort()
    {
      Assertions.assertEquals(Command.SORT, arguments.getCommand());
    }

    public void thenInputFileIs(String inputFileName)
    {
      Assertions.assertEquals(inputFileName, arguments.getInputFile());
    }

    public void thenOutputFileIs(String outputFileName)
    {
      Assertions.assertEquals(outputFileName, arguments.getOutputFile());
    }

    public void thenSortOrderIsAsc()
    {
      Assertions.assertEquals(Command.SORT, arguments.getCommand());
    }

    public void thenCommandIsSearch()
    {
      Assertions.assertEquals(Command.SEARCH, arguments.getCommand());
    }

    public void thenSearchTextIs(String searchText)
    {
      Assertions.assertEquals(searchText, arguments.getSearchText());
    }

    public void thenOutputFileIsNull()
    {
      Assertions.assertNull(arguments.getOutputFile());
    }

    public void thenCommandIsMerge()
    {
      Assertions.assertEquals(Command.MERGE, arguments.getCommand());
    }

    public void thenInputFilesAre(List<String> inputFiles)
    {
      Assertions.assertEquals(inputFiles, arguments.getInputFiles());
    }

    public void thenCommandIsReplace()
    {
      Assertions.assertEquals(Command.REPLACE, arguments.getCommand());
    }

    public void thenReplaceTextIs(String replaceText)
    {
      Assertions.assertEquals(replaceText, arguments.getReplaceText());
    }

    public void thenCommandIsDedup()
    {
      Assertions.assertEquals(Command.DEDUP, arguments.getCommand());
    }
  }
}
