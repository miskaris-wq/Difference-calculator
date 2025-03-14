package hexlet.code;

import hexlet.code.formatters.JsonFormatter;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.TreeMap;
import static org.junit.jupiter.api.Assertions.*;

class JsonFormatterTest {

    @Test
    void testFormat() throws Exception {
        String path1 = "./src/test/resources/file1.json";
        String path2 = "./src/test/resources/file2.json";


        String expected = """
                {
                  "follow" : {
                    "oldValue" : false,
                    "status" : "removed"
                  },
                  "host" : {
                    "status" : "unchanged",
                    "value" : "hexlet.io"
                  },
                  "proxy" : {
                    "oldValue" : "123.234.53.22",
                    "status" : "removed"
                  },
                  "timeout" : {
                    "newValue" : 20,
                    "oldValue" : 50,
                    "status" : "updated"
                  },
                  "verbose" : {
                    "newValue" : true,
                    "status" : "added"
                  }
                }""";

        String diff = Differ.generate(path1, path2, "json");
        assertEquals(expected, diff);
    }
}