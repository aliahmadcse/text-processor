package codes.aliahmad.logger;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

public class ConsoleLogger implements Logger
{
  private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger();

  public void log(Level level, String message)
  {
    logger.log(level, message);
  }
}
