package codes.aliahmad.utils;

import codes.aliahmad.models.Arguments;
import codes.aliahmad.models.Command;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TestFileMergerUtil
{
  private Fixture fixture;

  @BeforeEach
  public void setup()
  {
    fixture = new Fixture();
  }

  @Test
  public void test_mergingTwoFiles() throws IOException
  {
    fixture.givenMergeArgumentForTwoFiles();
    fixture.whenMergeFilesIsInvoked();
    fixture.thenAssertOutputFileHasMergedContentOfTwoFiles();
  }

  @Test
  public void test_mergeThreeFiles() throws IOException
  {
    fixture.givenMergeArgumentForThreeFiles();
    fixture.whenMergeFilesIsInvoked();
    fixture.thenAssertOutputFileHasMergedContentOfThreeFiles();
  }


  private static class Fixture
  {
    private Arguments arguments;
    private static final String INPUT_FILE = "./src/test/resources/input.txt";

    private static final String INPUT_FILE_2 = "./src/test/resources/input2.txt";

    private static final String INPUT_FILE_3 = "./src/test/resources/input3.txt";

    private static final String OUTPUT_FILE = "./src/test/resources/output.txt";
    private static final String OUTPUT_MERGED_TWO_FILES = "./src/test/resources/outputMergedTwoFiles.txt";
    private static final String OUTPUT_MERGED_THREE_FILES = "./src/test/resources/outputMergedThreeFiles.txt";


    public void givenMergeArgumentForTwoFiles()
    {
      arguments = new Arguments();
      arguments.setCommand(Command.SORT);
      arguments.setInputFiles(List.of(INPUT_FILE, INPUT_FILE_2));
      arguments.setOutputFile(OUTPUT_FILE);
    }

    public void whenMergeFilesIsInvoked()
    {
      FileMergerUtil.mergeFiles(arguments);
    }

    public void thenAssertOutputFileHasMergedContentOfTwoFiles() throws IOException
    {
      String expectedContent = new String(Files.readAllBytes(Paths.get(OUTPUT_MERGED_TWO_FILES)));
      String actualContent = new String(Files.readAllBytes(Paths.get(OUTPUT_FILE)));
      Assertions.assertEquals(expectedContent, actualContent);
    }

    public void givenMergeArgumentForThreeFiles()
    {
      arguments = new Arguments();
      arguments.setCommand(Command.SORT);
      arguments.setInputFiles(List.of(INPUT_FILE, INPUT_FILE_2, INPUT_FILE_3));
      arguments.setOutputFile(OUTPUT_FILE);
    }

    public void thenAssertOutputFileHasMergedContentOfThreeFiles() throws IOException
    {
      String expectedContent = new String(Files.readAllBytes(Paths.get(OUTPUT_MERGED_THREE_FILES)));
      String actualContent = new String(Files.readAllBytes(Paths.get(OUTPUT_FILE)));
      Assertions.assertEquals(expectedContent, actualContent);
    }

  }

}
