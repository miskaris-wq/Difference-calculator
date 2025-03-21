package hexlet.code;

import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.HashSet;

public class DiffBuilder {

    public static Map<String, Map<String, Object>> buildDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, Map<String, Object>> diff = new TreeMap<>();
        Set<String> allKeys = new HashSet<>(data1.keySet()); // Получаем все ключи из data1
        allKeys.addAll(data2.keySet()); // Добавляем все ключи из data2

        for (String key : allKeys) {
            Map<String, Object> keyDiff = new TreeMap<>();

            if (!data2.containsKey(key)) {
                // Ключ есть только в data1 — удалён
                keyDiff.put("status", "removed");
                keyDiff.put("oldValue", data1.get(key));
            } else if (!data1.containsKey(key)) {
                // Ключ есть только в data2 — добавлен
                keyDiff.put("status", "added");
                keyDiff.put("newValue", data2.get(key));
            } else if (!isEqualValues(data1.get(key), data2.get(key))) {
                // Ключ есть в обеих мапах, но значения различаются — обновлён
                keyDiff.put("status", "updated");
                keyDiff.put("oldValue", data1.get(key));
                keyDiff.put("newValue", data2.get(key));
            } else {
                // Ключ есть в обеих мапах, значения равны — без изменений
                keyDiff.put("status", "unchanged");
                keyDiff.put("value", data1.get(key));
            }

            diff.put(key, keyDiff);
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
