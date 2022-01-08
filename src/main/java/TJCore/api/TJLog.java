package TJCore.api;

import org.apache.logging.log4j.Logger;

public class TJLog {

    public static Logger logger;

    private TJLog() {
    }

    public static void init(Logger modLogger) {
        logger = modLogger;
    }
}

