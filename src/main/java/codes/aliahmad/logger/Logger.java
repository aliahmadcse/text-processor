package codes.aliahmad.logger;

import org.apache.logging.log4j.Level;

public interface Logger
{
  void log(Level level, String message);
}
