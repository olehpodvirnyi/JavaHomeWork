package Log;

import org.apache.log4j.Logger;

public class Task29 {
    private static final Logger logger = Logger.getLogger("Test log");

    public static void main(String[] args) {
        logger.trace("Trace Message!");
        logger.debug("Debug Message!");
        logger.info("Info Message!");
        logger.warn("Warn Message!");
        logger.error("Error Message!");
        logger.fatal("Fatal Message!");
    }

}
