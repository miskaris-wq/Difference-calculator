package hexlet.code.formatters;

import java.util.Map;
import java.util.TreeSet;

public class StylishFormatter {

    public static String format(Map<String, Map<String, Object>> diff) {
        StringBuilder result = new StringBuilder("{\n");

        for (Map.Entry<String, Map<String, Object>> entry : diff.entrySet()) {
            String key = entry.getKey();
            Map<String, Object> value = entry.getValue();

            switch (value.get("status").toString()) {
                case "removed":
                    appendLine(result, "- ", key, value.get("oldValue"));
                    break;
                case "added":
                    appendLine(result, "+ ", key, value.get("newValue"));
                    break;
                case "updated":
                    appendLine(result, "- ", key, value.get("oldValue"));
                    appendLine(result, "+ ", key, value.get("newValue"));
                    break;
                case "unchanged":
                    appendLine(result, "  ", key, value.get("value"));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown status: " + value.get("status"));
            }
        }

        result.append("}");
        return result.toString();
    }

    private static boolean isEqualValues(Object value1, Object value2) {
        if (value1 == null && value2 == null) {
            return true;
        }
        if (value1 == null || value2 == null) {
            return false;
        }
        return value1.equals(value2);
    }

    private static void appendLine(StringBuilder sb, String prefix, String key, Object value) {
        sb.append("  ")
                .append(prefix)
                .append(key)
                .append(": ")
                .append(formatValue(value))
                .append("\n");
    }

    private static String formatValue(Object value) {
        if (value instanceof Map || value instanceof Iterable) {
            return value.toString();
        } else if (value == null) {
            return "null";
        } else {
            return value.toString();
        }
    }
}
