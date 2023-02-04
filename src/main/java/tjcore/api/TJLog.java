package tjcore.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TJLog {

    public static Logger logger = LogManager.getLogger("tjcore");

    private TJLog() {
    }

    public static void init(Logger modLogger) {
        logger = modLogger;
    }
}

