package hexlet.code.formatters;

import java.util.Map;
import java.util.TreeMap;

public class DiffBuilder {

    public static Map<String, Map<String, Object>> buildDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, Map<String, Object>> diff = new TreeMap<>();

        for (String key : data1.keySet()) {
            Map<String, Object> keyDiff = new TreeMap<>();
            if (!data2.containsKey(key)) {
                keyDiff.put("status", "removed");
                keyDiff.put("oldValue", data1.get(key));
                diff.put(key, keyDiff);
            } else if (!isEqualValues(data1.get(key), data2.get(key))) {
                keyDiff.put("status", "updated");
                keyDiff.put("oldValue", data1.get(key));
                keyDiff.put("newValue", data2.get(key));
                diff.put(key, keyDiff);
            } else {
                keyDiff.put("status", "unchanged");
                keyDiff.put("value", data1.get(key));
                diff.put(key, keyDiff);
            }
        }

        for (String key : data2.keySet()) {
            if (!data1.containsKey(key)) {
                Map<String, Object> keyDiff = new TreeMap<>();
                keyDiff.put("status", "added");
                keyDiff.put("newValue", data2.get(key));
                diff.put(key, keyDiff);
            }
        }

        return diff;
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