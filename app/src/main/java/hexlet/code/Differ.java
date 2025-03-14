package hexlet.code;

import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.util.Map;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Map<String, Object> data1 = Parser.parse(filepath1);
        Map<String, Object> data2 = Parser.parse(filepath2);

        switch (format) {
            case "plain":
                return PlainFormatter.format(data1, data2);
            case "stylish":
                return StylishFormatter.format(data1, data2);
            case "json":
                return JsonFormatter.format(data1, data2);
            default:
                throw new IllegalArgumentException("Unsupported format: " + format);
        }
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
}
