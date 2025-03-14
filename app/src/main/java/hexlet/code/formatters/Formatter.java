package hexlet.code.formatters;

import java.util.Map;

public class Formatter {

    public static String format(Map<String, Object> data1, Map<String, Object> data2, String format) {
        return switch (format) {
            case "plain" -> PlainFormatter.format(data1, data2);
            case "stylish" -> StylishFormatter.format(data1, data2);
            default -> throw new IllegalArgumentException("Unsupported format: " + format);
        };
    }
}