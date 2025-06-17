package main

import (
	"log/slog"
	"os"
	"time"
)

func main() {
	// Configure structured logging with JSON output
	logger := slog.New(slog.NewJSONHandler(os.Stdout, &slog.HandlerOptions{
		Level: slog.LevelDebug,
	}))

	counter := 0

	logger.Info("Starting Go basic logging example")
	logger.Info("Demonstrating Go slog structured logging")

	// Infinite loop with different log levels
	for {
		counter++

		// Cycle through different log levels
		logType := counter % 4

		switch logType {
		case 0:
			logger.Debug("Basic debug message", "counter", counter)
		case 1:
			logger.Info("Information message", "counter", counter)
		case 2:
			logger.Warn("Warning message", "counter", counter)
		case 3:
			logger.Error("Error message", "counter", counter)
		}

		// Wait 1 second before next log
		time.Sleep(1 * time.Second)
	}
}
