package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;

public class Formatter {

    public static String format(Map<String, Map<String, Object>> diff, String format) throws JsonProcessingException {
        return switch (format) {
            case "plain" -> PlainFormatter.format(diff);
            case "stylish" -> StylishFormatter.format(diff);
            case "json" -> JsonFormatter.format(diff);
            default -> throw new IllegalArgumentException("Unsupported format: " + format);
        };
    }
}
