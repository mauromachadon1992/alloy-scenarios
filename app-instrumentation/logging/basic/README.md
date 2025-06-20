# App Instrumentation - Basic Logging Examples (NOT FINISHED)

This directory contains basic logging examples for 7 popular programming languages, each using built-in or industry-standard logging approaches without external dependencies.

## Languages and Frameworks

| Language | Logging Framework | Built-in/Standard | Docker Base Image |
|----------|------------------|-------------------|-------------------|
| JavaScript | `console` methods | ✅ Built-in Node.js console API | `node:22-alpine` |
| Python | `logging` module | ✅ Built-in Python standard library | `python:3.12-slim` |
| Java | `java.util.logging` (JUL) | ✅ Built-in Java standard library | `openjdk:26-slim` |
| C# | `Microsoft.Extensions.Logging` | ✅ .NET standard logging framework | `mcr.microsoft.com/dotnet/*:9.0` |
| C++ | `spdlog` | ✅ Industry standard (no built-in logging) | `ubuntu:24.04` |
| Go | `log/slog` | ✅ Built-in Go structured logging | `golang:1.23-alpine` |
| PHP | `error_log()` function | ✅ Built-in PHP logging function | `php:8.3-cli-alpine` |

## Directory Structure

```
app-instrumentation/
├── javascript/
│   ├── app.js
│   └── Dockerfile
├── python/
│   ├── app.py
│   └── Dockerfile
├── java/
│   ├── App.java
│   └── Dockerfile
├── csharp/
│   ├── Program.cs
│   ├── LoggingExample.csproj
│   └── Dockerfile
├── cpp/
│   ├── main.cpp
│   ├── CMakeLists.txt
│   └── Dockerfile
├── go/
│   ├── main.go
│   └── Dockerfile
├── php/
│   ├── app.php
│   └── Dockerfile
├── docker-compose.yml
└── README.md
```

## Logging Features Demonstrated

Each example demonstrates:

- **Built-in logging**: Using each language's standard/built-in logging capabilities
- **Proper log levels**: DEBUG, INFO, WARN/WARNING, ERROR, CRITICAL/FATAL as supported
- **Native output**: Using each framework's natural output format and behavior
- **Minimal dependencies**: No external logging libraries required
- **Continuous operation**: Infinite loops demonstrating long-running application logging

## Usage

### Run All Examples with Docker Compose

```bash
# Build and run all logging examples
docker-compose up --build

# Run in detached mode
docker-compose up --build -d

# View logs from all containers
docker-compose logs -f

# View logs from a specific service
docker-compose logs -f javascript-logging
```

### Run Individual Examples

```bash
# JavaScript
cd javascript && docker build -t js-logging . && docker run js-logging

# Python
cd python && docker build -t py-logging . && docker run py-logging

# Java
cd java && docker build -t java-logging . && docker run java-logging

# C#
cd csharp && docker build -t csharp-logging . && docker run csharp-logging

# C++
cd cpp && docker build -t cpp-logging . && docker run cpp-logging

# Go
cd go && docker build -t go-logging . && docker run go-logging

# PHP
cd php && docker build -t php-logging . && docker run php-logging
```

### Clean Up

```bash
# Stop and remove all containers
docker-compose down

# Remove all built images
docker-compose down --rmi all
```

## Key Logging Concepts Demonstrated

1. **Log Levels**: Each example shows how to use different severity levels (DEBUG, INFO, WARN, ERROR, CRITICAL)
2. **Core Framework Usage**: Demonstrates the built-in logging methods for each language
3. **Basic Configuration**: Simple setup of logging frameworks with console output
4. **Message Formatting**: Basic string interpolation and parameter passing to log messages
5. **Continuous Logging**: Shows how logging works in long-running applications

## Environment Variables

Each container accepts environment variables to modify behavior:

- `NODE_ENV` (JavaScript)
- `PYTHON_ENV` (Python) 
- `JAVA_ENV` (Java)
- `DOTNET_ENVIRONMENT` (C#)
- `CPP_ENV` (C++)
- `GO_ENV` (Go)
- `PHP_ENV` (PHP)

## Notes

- All applications run infinite loops demonstrating continuous logging behavior
- Each application logs every 1 second, cycling through all supported log levels
- Proper formatting for each language's logging framework
- Well-configured setups suitable for learning and demonstration
- Clean, structured output that follows each language's logging conventions
- Applications run continuously until manually stopped (no restart needed)
- Docker images use current 2025 versions (Node 22 LTS, Python 3.12, Java 26, .NET 9, Ubuntu 24.04, Go 1.23, PHP 8.3) 