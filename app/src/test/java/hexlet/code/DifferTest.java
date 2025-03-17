package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Files;
import java.nio.file.Paths;

class DifferTest {

    @Test
    void testGenerateDiffStylishJson() throws Exception {
        String path1 = "./src/test/resources/file1.json";
        String path2 = "./src/test/resources/file2.json";

        String expected = readFile("./src/test/resources/expected_stylish.txt");
        String diff = Differ.generate(path1, path2, "stylish");

        assertEquals(expected, diff);
    }

    @Test
    void testGenerateDiffPlainJson() throws Exception {
        String path1 = "./src/test/resources/file1.json";
        String path2 = "./src/test/resources/file2.json";

        String expected = readFile("./src/test/resources/expected_plain.txt");
        String diff = Differ.generate(path1, path2, "plain");

        assertEquals(expected, diff);
    }

    @Test
    void testGenerateDiffJsonFormatJson() throws Exception {
        String path1 = "./src/test/resources/file1.json";
        String path2 = "./src/test/resources/file2.json";

        String expected = readFile("./src/test/resources/expected_json.json");
        String diff = Differ.generate(path1, path2, "json");

        assertEquals(expected, diff);
    }

    @Test
    void testGenerateDiffStylishYaml() throws Exception {
        String path1 = "./src/test/resources/file1.yml";
        String path2 = "./src/test/resources/file2.yml";

        String expected = readFile("./src/test/resources/expected_stylish.txt");
        String diff = Differ.generate(path1, path2, "stylish");

        assertEquals(expected, diff);
    }

    @Test
    void testGenerateDiffPlainYaml() throws Exception {
        String path1 = "./src/test/resources/file1.yml";
        String path2 = "./src/test/resources/file2.yml";

        String expected = readFile("./src/test/resources/expected_plain.txt");
        String diff = Differ.generate(path1, path2, "plain");

        assertEquals(expected, diff);
    }

    @Test
    void testGenerateDiffJsonFormatYaml() throws Exception {
        String path1 = "./src/test/resources/file1.yml";
        String path2 = "./src/test/resources/file2.yml";

        String expected = readFile("./src/test/resources/expected_json.json");
        String diff = Differ.generate(path1, path2, "json");

        assertEquals(expected, diff);
    }

    private String readFile(String path) throws Exception {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}