package hexlet.code.formatters;

import java.util.Map;
import java.util.TreeSet;

public class StylishFormatter {

    public static String format(Map<String, Object> data1, Map<String, Object> data2) {
        StringBuilder result = new StringBuilder("{\n");
        TreeSet<String> allKeys = new TreeSet<>();
        allKeys.addAll(data1.keySet());
        allKeys.addAll(data2.keySet());

        for (String key : allKeys) {
            Object value1 = data1.get(key);
            Object value2 = data2.get(key);

            if (!data2.containsKey(key)) {
                appendLine(result, "- ", key, value1);
            } else if (!data1.containsKey(key)) {
                appendLine(result, "+ ", key, value2);
            } else if (!isEqualValues(value1, value2)) {
                appendLine(result, "- ", key, value1);
                appendLine(result, "+ ", key, value2);
            } else {
                appendLine(result, "  ", key, value1);
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
            return "[complex value]";
        } else if (value == null) {
            return "null";
        } else {
            return value.toString();
        }
    }

}