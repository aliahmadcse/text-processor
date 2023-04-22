package codes.aliahmad;

import codes.aliahmad.logger.ConsoleLogger;
import codes.aliahmad.logger.Logger;
import codes.aliahmad.models.Arguments;
import codes.aliahmad.utils.ArgUtil;
import codes.aliahmad.utils.DeDupUtil;
import codes.aliahmad.utils.FileMergerUtil;
import codes.aliahmad.utils.ReplaceTextUtil;
import codes.aliahmad.utils.SearchTextUtil;
import codes.aliahmad.utils.SortLinesUtil;

import java.io.IOException;

public class TextProcessor
{

  private static final Logger logger = new ConsoleLogger();

  public static void main(String[] args) throws IOException
  {
    // parse the arguments
    Arguments arguments = new ArgUtil().parseArguments(args);
    System.out.println(arguments);

    switch (arguments.getCommand())
    {
      case SORT -> SortLinesUtil.sort(arguments);
      case SEARCH -> SearchTextUtil.search(arguments);
      case REPLACE -> ReplaceTextUtil.replace(arguments);
      case DEDUP -> DeDupUtil.removeDuplicateLines(arguments);
      case MERGE -> FileMergerUtil.mergeFiles(arguments);
    }

  }
}
