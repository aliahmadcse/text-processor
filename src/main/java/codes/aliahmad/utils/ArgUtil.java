package codes.aliahmad.utils;

import codes.aliahmad.logger.ConsoleLogger;
import codes.aliahmad.logger.Logger;
import codes.aliahmad.models.Arguments;
import codes.aliahmad.models.Command;
import codes.aliahmad.models.SortOrder;
import org.apache.logging.log4j.Level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArgUtil
{
  private static final Logger LOGGER = new ConsoleLogger();

  public Arguments parseArguments(String[] args)
  {
    Arguments arguments = new Arguments();

    if (!validate(args))
    {
      throw new IllegalArgumentException("Invalid arguments");
    }

    Command command = getCommandFromArgs(args);
    arguments.setCommand(command);

    switch (command)
    {
      case SORT -> parseSortArgs(args, arguments);
      case SEARCH -> parseSearchArgs(args, arguments);
      case REPLACE -> parseReplaceArgs(args, arguments);
      case MERGE -> parseMergeArgs(args, arguments);
      case DEDUP -> parseDedupArgs(args, arguments);
    }

    return arguments;
  }

  private void parseDedupArgs(String[] args, Arguments arguments)
  {
    if (args.length < 5)
    {
      LOGGER.log(Level.ERROR, "Not enough arguments");
      throw new IllegalArgumentException("Invalid arguments");
    }
    parseInputFile(args, arguments);
    parseOutputFile(args, arguments);
  }

  private void parseMergeArgs(String[] args, Arguments arguments)
  {
//    there should at least be 2 input files to merge
    if (args.length < 6)
    {
      LOGGER.log(Level.ERROR, "Not enough arguments");
      throw new IllegalArgumentException("Not enough arguments");
    }
    parseOutputFile(args, arguments);
    parseMultipleInputFiles(args, arguments);
  }

  private void parseMultipleInputFiles(String[] args, Arguments arguments)
  {
    int index = Arrays.asList(args).indexOf("--input-files");

    if (index == -1)
    {
      LOGGER.log(Level.ERROR, "Input files not specified");
      throw new IllegalArgumentException("Input files not specified");
    }

    List<String> inputFiles = new ArrayList<>();
    for (int i = index + 1; i < args.length; i++)
    {
      if (args[i].startsWith("--"))
      {
        break;
      }
      inputFiles.add(args[i]);
    }

    arguments.setInputFiles(inputFiles);
  }

  private void parseReplaceArgs(String[] args, Arguments arguments)
  {
    if (args.length < 9)
    {
      LOGGER.log(Level.ERROR, "Not enough arguments");
      throw new IllegalArgumentException("Not enough arguments");
    }
    parseInputFile(args, arguments);
    parseOutputFile(args, arguments);
    parseSearchText(args, arguments);
    parseReplaceText(args, arguments);
  }

  private void parseReplaceText(String[] args, Arguments arguments)
  {
    int index = Arrays.asList(args).indexOf("--replace-text");

    if (index == -1)
    {
      LOGGER.log(Level.ERROR, "Replace text not specified");
      throw new IllegalArgumentException("Replace text not specified");
    }

    arguments.setReplaceText(args[index + 1]);
  }

  private void parseSearchArgs(String[] args, Arguments arguments)
  {
    if (args.length < 5)
    {
      LOGGER.log(Level.ERROR, "Not enough arguments");
      throw new IllegalArgumentException("Not enough arguments");
    }
    parseInputFile(args, arguments);
    parseSearchText(args, arguments);
  }

  private void parseSearchText(String[] args, Arguments arguments)
  {
    int index = Arrays.asList(args).indexOf("--search-text");

    if (index == -1)
    {
      LOGGER.log(Level.ERROR, "Search text not specified");
      throw new IllegalArgumentException("Search text not specified");
    }

    arguments.setSearchText(args[index + 1]);
  }

  private void parseSortArgs(String[] args, Arguments arguments)
  {
    if (args.length < 7)
    {
      LOGGER.log(Level.ERROR, "Not enough arguments");
      throw new IllegalArgumentException("Invalid arguments");
    }
    parseInputFile(args, arguments);
    parseOutputFile(args, arguments);
    parseSortOrder(args, arguments);
  }

  private void parseSortOrder(String[] args, Arguments arguments)
  {
    int index = Arrays.asList(args).indexOf("--order");

    if (index == -1)
    {
      LOGGER.log(Level.ERROR, "Sort order not specified");
      throw new IllegalArgumentException("Sort order not specified");
    }

    try
    {
      arguments.setSortOrder(SortOrder.valueOf(args[index + 1].toUpperCase()));
    }
    catch (IllegalArgumentException e)
    {
      LOGGER.log(Level.ERROR, "Invalid sorting order");
      throw new IllegalArgumentException("Invalid sorting order");
    }
  }

  private void parseOutputFile(String[] args, Arguments arguments)
  {
    int index = Arrays.asList(args).indexOf("--output-file");

    if (index == -1)
    {
      LOGGER.log(Level.ERROR, "Invalid output file");
      throw new IllegalArgumentException("Invalid output file");
    }
    arguments.setOutputFile(args[index + 1]);
  }

  private void parseInputFile(String[] args, Arguments arguments)
  {
    int index = Arrays.asList(args).indexOf("--input-file");

    if (index == -1)
    {
      LOGGER.log(Level.ERROR, "Invalid input file");
      throw new IllegalArgumentException("Invalid input file");
    }
    arguments.setInputFile(args[index + 1]);
  }

  private boolean validate(String[] args)
  {
    if (args.length < 1)
    {
      LOGGER.log(Level.ERROR, "Not enough arguments");
      return false;
    }
    return true;
  }

  private Command getCommandFromArgs(String[] args)
  {
    try
    {
      return Command.valueOf(args[0].toUpperCase());
    }
    catch (IllegalArgumentException e)
    {
      LOGGER.log(Level.ERROR, "Invalid command");
      throw new IllegalArgumentException("Invalid Command");
    }
  }
}
