package hexlet.code.formatters;

import java.util.Map;
import java.util.TreeSet;

public class PlainFormatter {

    public static String format(Map<String, Map<String, Object>> diff) {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, Map<String, Object>> entry : diff.entrySet()) {
            String key = entry.getKey();
            Map<String, Object> value = entry.getValue();

            switch (value.get("status").toString()) {
                case "removed":
                    result.append(String.format("Property '%s' was removed\n", key));
                    break;
                case "added":
                    result.append(String.format("Property '%s' was added with value: %s\n",
                            key, formatValue(value.get("newValue"))));
                    break;
                case "updated":
                    result.append(String.format("Property '%s' was updated. From %s to %s\n",
                            key, formatValue(value.get("oldValue")), formatValue(value.get("newValue"))));
                    break;
                default:
                    break;
            }
        }

        return result.toString().trim();
    }

    private static String formatValue(Object value) {
        if (value instanceof Map || value instanceof Iterable) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return String.valueOf(value);
        }
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
}
