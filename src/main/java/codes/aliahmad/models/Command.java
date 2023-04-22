package codes.aliahmad.models;

public enum Command
{
  SORT("sort"),
  DEDUP("dedup"),
  SEARCH("search"),
  REPLACE("replace"),
  MERGE("merge");

  private final String command;

  private Command(String command)
  {
    this.command = command;
  }

  public String getCommand()
  {
    return command;
  }
}
