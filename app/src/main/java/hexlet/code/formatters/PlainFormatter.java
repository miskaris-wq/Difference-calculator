package hexlet.code.formatters;

import java.util.Map;

public class PlainFormatter {

    public static String format(Map<String, Object> data1, Map<String, Object> data2) {
        StringBuilder result = new StringBuilder();

        for (String key : data1.keySet()) {
            if (!data2.containsKey(key)) {
                result.append(String.format("Property '%s' was removed\n", key));
            } else if (!isEqualValues(data1.get(key), data2.get(key))) {
                result.append(String.format("Property '%s' was updated. From %s to %s\n",
                        key, formatValue(data1.get(key)), formatValue(data2.get(key))));
            }
        }

        for (String key : data2.keySet()) {
            if (!data1.containsKey(key)) {
                result.append(String.format("Property '%s' was added with value: %s\n",
                        key, formatValue(data2.get(key))));
            }
        }

        return result.toString().trim();
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

    private static String formatValue(Object value) {
        if (value instanceof Map || value instanceof Iterable) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return String.valueOf(value);
        }
    }
}
