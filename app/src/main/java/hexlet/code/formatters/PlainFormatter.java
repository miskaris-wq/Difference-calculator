package hexlet.code.formatters;

import java.util.Map;
import java.util.TreeSet;

public class PlainFormatter {

    public static String format(Map<String, Object> data1, Map<String, Object> data2) {
        StringBuilder result = new StringBuilder();

        TreeSet<String> allKeys = new TreeSet<>();
        allKeys.addAll(data1.keySet());
        allKeys.addAll(data2.keySet());

        for (String key : allKeys) {
            Object value1 = data1.get(key);
            Object value2 = data2.get(key);

            if (!data2.containsKey(key)) {
                result.append(String.format("Property '%s' was removed\n", key));
            } else if (!data1.containsKey(key)) {
                result.append(String.format("Property '%s' was added with value: %s\n",
                        key, formatValue(data2.get(key))));
            } else if (!isEqualValues(value1, value2)) {
                result.append(String.format("Property '%s' was updated. From %s to %s\n",
                        key, formatValue(value1), formatValue(value2)));
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
