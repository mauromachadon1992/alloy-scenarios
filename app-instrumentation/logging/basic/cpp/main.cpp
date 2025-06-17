#include <spdlog/spdlog.h>
#include <spdlog/sinks/stdout_color_sinks.h>
#include <chrono>
#include <thread>

int main() {
    // Configure spdlog with structured format
    auto console = spdlog::stdout_color_mt("logger");
    spdlog::set_default_logger(console);
    spdlog::set_level(spdlog::level::debug);
    // Structured format: timestamp [level] logger_name - message
    spdlog::set_pattern("%Y-%m-%d %H:%M:%S.%e [%^%l%$] %n - %v");

    int counter = 0;

    spdlog::info("Starting C++ basic logging example");
    spdlog::info("Demonstrating spdlog formatting");

    // Infinite loop with different log levels
    while (true) {
        counter++;

        // Cycle through different log levels
        int logType = counter % 5;

        switch (logType) {
            case 0:
                spdlog::debug("Basic debug message, counter: {}", counter);
                break;
            case 1:
                spdlog::info("Information message, counter: {}", counter);
                break;
            case 2:
                spdlog::warn("Warning message, counter: {}", counter);
                break;
            case 3:
                spdlog::error("Error message, counter: {}", counter);
                break;
            case 4:
                spdlog::critical("Critical message, counter: {}", counter);
                break;
        }

        // Wait 1 second before next log
        std::this_thread::sleep_for(std::chrono::seconds(1));
    }

    return 0;
} 