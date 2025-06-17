<?php

// Configure PHP built-in logging
ini_set('log_errors', 1);
ini_set('error_log', 'php://stdout');

$counter = 0;

error_log("Starting PHP basic logging example");
error_log("Demonstrating PHP built-in error_log function");

// Infinite loop with different log levels
while (true) {
    $counter++;
    
    // Cycle through different log levels
    $logType = $counter % 4;
    
    switch ($logType) {
        case 0:
            // Debug level - use error_log with prefix
            error_log("DEBUG: Basic debug message, counter: $counter");
            break;
        case 1:
            // Info level
            error_log("INFO: Information message, counter: $counter");
            break;
        case 2:
            // Warning level - use trigger_error for warnings
            error_log("WARNING: Warning message, counter: $counter");
            break;
        case 3:
            // Error level - use error_log for errors
            error_log("ERROR: Error message, counter: $counter");
            break;
    }
    
    // Wait 1 second before next log
    sleep(1);
}
?> 