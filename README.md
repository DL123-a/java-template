# Java Template

## Project Structure

```
3_profiling/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/profiling/
│   │           └── Main.java
│   └── test/
│       └── java/
│           └── com/profiling/
│               └── MainTest.java
├── lib/                    # JUnit JAR for testing
├── out/
│   ├── main/              # Compiled main classes
│   └── test/              # Compiled test classes
├── recordings/            # JFR recordings output
├── Makefile
└── README.md
```

## Requirements

- **JDK 25** (OpenJDK 25.0.2 or compatible)
- **Make** (for running build commands)

## Setup

### 1. Verify JDK Installation

The Makefile expects JDK 25 to be available. It will use:
- `JAVA_HOME` environment variable if set
- Default location: `/opt/homebrew/opt/openjdk` (macOS Homebrew)

To verify your JDK version:
```bash
java --version
```

## Usage

### Compile the Project

```bash
make compile
```

Compiles all Java sources in `src/main/java/` to `out/main/`.

### Run the Application

```bash
make run
```

Compiles (if needed) and runs the main application.

### Compile Tests

```bash
make compile-test
```

Compiles test sources. Requires JUnit JAR in `lib/` directory.

### Run Tests

```bash
make test
```

Compiles and runs all JUnit tests.

### Profile with Java Flight Recorder

```bash
make profile
```

Runs the application with JFR profiling enabled. The recording will be saved to `recordings/` directory with a timestamp.

**JFR Configuration:**
- Duration: 60 seconds (configurable in Makefile)
- Settings: `profile` (higher overhead, more detailed profiling)
- Output: Timestamped `.jfr` files in `recordings/`

### View JFR Recordings

After profiling, you can view the recordings using:

**Java Mission Control (JMC):**
```bash
jmc recordings/app-YYYYMMDD-HHMMSS.jfr
```

**Command-line JFR tool:**
```bash
jfr print recordings/app-YYYYMMDD-HHMMSS.jfr
```

**Summary view:**
```bash
jfr summary recordings/app-YYYYMMDD-HHMMSS.jfr
```

### Clean Build Artifacts

```bash
make clean
```

Removes all compiled classes and JFR recordings.

### Help

```bash
make help
```

Shows all available Makefile targets.

## Customizing JFR Settings

Edit the Makefile to customize JFR options:

```makefile
JFR_DURATION = 60s        # Recording duration
JFR_SETTINGS = profile    # JFR settings preset (default, profile, etc.)
```

Available JFR settings presets:
- `default` - Low overhead, basic events
- `profile` - Higher overhead, detailed profiling
- `lowoverhead` - Minimal overhead

For more options, see: https://docs.oracle.com/en/java/javase/25/docs/specs/man/java.html#java-flight-recorder

## Example Workflow

1. **Compile and run:**
   ```bash
   make run
   ```

2. **Run tests:**
   ```bash
   make test
   ```

3. **Profile the application:**
   ```bash
   make profile
   ```

4. **Analyze the recording:**
   ```bash
   jmc recordings/app-*.jfr
   ```

## Troubleshooting

### "JUnit JAR not found"
- Ensure `junit-platform-console-standalone.jar` is in the `lib/` directory
- Download it using the instructions in the Setup section

### "Unable to locate Java Runtime"
- Set `JAVA_HOME` environment variable:
  ```bash
  export JAVA_HOME=/opt/homebrew/opt/openjdk
  ```
- Or update the `JAVA_HOME` variable in the Makefile

### JFR recording not created
- Ensure the `recordings/` directory exists (created automatically)
- Check that the application runs long enough for the recording duration
- Verify JDK 25 is being used (JFR requires JDK 7u40+)

## Notes

- This project uses pure Java commands without Maven, Gradle, or other build tools
- All compilation and execution is handled through the Makefile
- JFR recordings are timestamped to avoid overwriting previous recordings
- The sample `Main.java` includes various CPU-intensive operations useful for profiling demonstrations
