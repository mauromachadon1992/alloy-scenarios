#!/usr/bin/env node

let counter = 0;

console.log('Starting JavaScript basic logging example');
console.log('Demonstrating built-in console methods');

// Function to log with different levels
function logMessage() {
    counter++;
    
    // Cycle through different log levels - built-in console methods
    const logType = counter % 4;
    
    switch (logType) {
        case 0:
            console.debug('Basic debug message, counter:', counter);
            break;
        case 1:
            console.info('Information message, counter:', counter);
            break;
        case 2:
            console.warn('Warning message, counter:', counter);
            break;
        case 3:
            console.error('Error message, counter:', counter);
            break;
    }
}

// Log every 1 second infinitely
setInterval(logMessage, 1000); 