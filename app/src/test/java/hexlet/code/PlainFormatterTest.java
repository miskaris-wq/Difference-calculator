package hexlet.code;
import hexlet.code.formatters.PlainFormatter;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.TreeMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PlainFormatterTest {
    private  final int valueForKey21 = 42;
    private  final int valueForKey22 = 100;

    @Test
    void testFormat() {
        Map<String, Object> data1 = new TreeMap<>();
        data1.put("key1", "value1");
        data1.put("key2", valueForKey21);
        data1.put("key3", true);

        Map<String, Object> data2 = new TreeMap<>();
        data2.put("key1", "value1");
        data2.put("key2", valueForKey22);
        data2.put("key4", "new value");

        String expected = """
                Property 'key2' was updated. From 42 to 100
                Property 'key3' was removed
                Property 'key4' was added with value: 'new value'
                """.trim();

        String result = PlainFormatter.format(data1, data2);
        assertEquals(expected, result);
    }
}
