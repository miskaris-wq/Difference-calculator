package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class JsonParserTest {
    @Test
    void testParseJsonValidFile() throws Exception {
        String path = "./src/test/resources/test1.json";
        Map<String, Object> data = JsonParser.parseJson(path);
        assertNotNull(data);
        assertTrue(data.containsKey("host"));
        assertTrue(data.containsKey("timeout"));
        assertTrue(data.containsKey("verbose"));
    }

    @Test
    void testParseJsonInvalidFile() throws Exception {
        String path = "./src/test/resources/nonexistent.json";
        assertThrows(Exception.class, () -> JsonParser.parseJson(path));
    }

    @Test
    void testParseJsonMalformedJson() throws Exception {
        String path = "./src/test/resources/malformed.json";
        assertThrows(Exception.class, () -> JsonParser.parseJson(path));
    }

}
