import java.util.logging.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());
    
    // Custom formatter for structured logging
    static class StandardFormatter extends Formatter {
        private static final DateTimeFormatter TIMESTAMP_FORMAT = 
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        
        @Override
        public String format(LogRecord record) {
            return String.format("%s [%s] %s - %s%n",
                LocalDateTime.now().format(TIMESTAMP_FORMAT),
                record.getLevel(),
                record.getLoggerName(),
                record.getMessage()
            );
        }
    }
    
    static {
        // Configure logging with structured format
        Logger rootLogger = Logger.getLogger("");
        // Remove default handlers
        Handler[] handlers = rootLogger.getHandlers();
        for (Handler handler : handlers) {
            rootLogger.removeHandler(handler);
        }
        
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new StandardFormatter());
        rootLogger.addHandler(consoleHandler);
        rootLogger.setLevel(Level.ALL);
    }
    
    public static void main(String[] args) {
        int counter = 0;
        
        logger.info("Starting Java basic logging example");
logger.info("Demonstrating Java logging (JUL)");
        
        // Infinite loop with different log levels
        while (true) {
            counter++;
            
            // Cycle through different log levels
            int logType = counter % 5;
            
            switch (logType) {
                case 0:
                    logger.fine("Basic debug message, counter: " + counter);
                    break;
                case 1:
                    logger.info("Information message, counter: " + counter);
                    break;
                case 2:
                    logger.warning("Warning message, counter: " + counter);
                    break;
                case 3:
                    logger.severe("Error message, counter: " + counter);
                    break;
                case 4:
                    logger.log(Level.SEVERE, "Critical message, counter: " + counter);
                    break;
            }
            
            // Wait 1 second before next log
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.warning("Thread interrupted: " + e.getMessage());
                break;
            }
        }
    }
} 