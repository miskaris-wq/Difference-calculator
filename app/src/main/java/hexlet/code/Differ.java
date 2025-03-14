package hexlet.code;

import java.util.TreeSet;
import java.util.Map;

public class Differ {

    public static String generate(String filepath1, String filepath2) {
        try {
            Map<String, Object> data1 = Parser.parse(filepath1);
            Map<String, Object> data2 = Parser.parse(filepath2);

            StringBuilder diff = new StringBuilder("{\n");

            TreeSet<String> allKeys = new TreeSet<>();
            allKeys.addAll(data1.keySet());
            allKeys.addAll(data2.keySet());

            for (String key : allKeys) {
                Object value1 = data1.get(key);
                Object value2 = data2.get(key);

                if (!data2.containsKey(key)) {
                    appendLine(diff, "- ", key, value1);
                } else if (!data1.containsKey(key)) {
                    appendLine(diff, "+ ", key, value2);
                } else if (!isEqualValues(value1, value2)) {
                    appendLine(diff, "- ", key, value1);
                    appendLine(diff, "+ ", key, value2);
                } else {
                    appendLine(diff, "  ", key, value1);
                }
            }

            diff.append("}");
            return diff.toString().trim();
        } catch (Exception e) {
            throw new RuntimeException("Error generating diff: " + e.getMessage(), e);
        }
    }

    private static void appendLine(StringBuilder sb, String prefix, String key, Object value) {
        sb.append("  ")
                .append(prefix)
                .append(key)
                .append(": ")
                .append(value)
                .append("\n");
    }

    private static boolean isEqualValues(Object value1, Object value2) {
        if (value1 == null && value2 == null) {
            return true;
        }
        if (value1 == null || value2 == null) {
            return false;
        }

        return value1.toString().equals(value2.toString());
    }
}
