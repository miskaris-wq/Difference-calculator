package hexlet.code;

import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AppTest {
    @Test
    void testAppRunsWithValidFiles() throws Exception {
        String[] args = {"./src/test/resources/test1.json", "./src/test/resources/test2.json"};
        int exitCode = new CommandLine(new App()).execute(args);
        assertEquals(0, exitCode);
    }


    @Test
    void testAppRunWithHelpOption() throws Exception {
        String[] args = {"-h"};
        int exitCode = new CommandLine(new App()).execute(args);
        assertEquals(0, exitCode);
    }

    @Test
    void testAppRunWithVersionOption() throws Exception {
        String[] args = {"-V"};
        int exitCode = new CommandLine(new App()).execute(args);
        assertEquals(0, exitCode);
    }
    @Test
    void testAppRunWithFormatOption() throws Exception {
        String[] args = {"-f", "stylish", "./src/test/resources/test1.json", "./src/test/resources/test2.json"};
        int exitCode = new CommandLine(new App()).execute(args);
        assertEquals(0, exitCode);
    }


}
