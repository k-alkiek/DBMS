package eg.edu.alexu.csd.oop.db.cs15;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Log {
    private static final Logger log = LogManager.getRootLogger();
    public static Logger getLogger() {
        return log;
    }
}
