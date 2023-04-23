package codes.aliahmad.models;

import java.util.List;

public class Arguments
{
  private Command command;
  private String inputFile;
  private String outputFile;
  private SortOrder sortOrder;
  private String searchText;
  private String replaceText;
  private List<String> inputFiles;

  public Command getCommand()
  {
    return command;
  }

  public void setCommand(Command command)
  {
    this.command = command;
  }

  public String getInputFile()
  {
    return inputFile;
  }

  public void setInputFile(String inputFile)
  {
    this.inputFile = inputFile;
  }

  public String getOutputFile()
  {
    return outputFile;
  }

  public void setOutputFile(String outputFile)
  {
    this.outputFile = outputFile;
  }

  public SortOrder getSortOrder()
  {
    return sortOrder;
  }

  public void setSortOrder(SortOrder sortOrder)
  {
    this.sortOrder = sortOrder;
  }

  public void setSearchText(String searchText)
  {
    this.searchText = searchText;
  }

  public String getSearchText()
  {
    return searchText;
  }

  public void setReplaceText(String replaceText)
  {
    this.replaceText = replaceText;
  }

  public String getReplaceText()
  {
    return replaceText;
  }

  public void setInputFiles(List<String> inputFiles)
  {
    this.inputFiles = inputFiles;
  }

  public List<String> getInputFiles()
  {
    return inputFiles;
  }

  @Override
  public String toString()
  {
    return "Arguments{" +
            "command=" + command +
            ", inputFile='" + inputFile + '\'' +
            ", outputFile='" + outputFile + '\'' +
            ", sortOrder=" + sortOrder +
            ", searchText='" + searchText + '\'' +
            ", replaceText='" + replaceText + '\'' +
            ", inputFiles=" + inputFiles +
            '}';
  }
}
