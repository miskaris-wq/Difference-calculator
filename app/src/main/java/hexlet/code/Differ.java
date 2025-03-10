package hexlet.code;

import java.util.Arrays;
import java.util.Map;

public class Differ {

    public static String generate(String filepath1, String filepath2) {
        try {
            Map<String, Object> data1 = JsonParser.parseJson(filepath1);
            Map<String, Object> data2 = JsonParser.parseJson(filepath2);

            StringBuilder diff = new StringBuilder();
            diff.append("{\n");

            // Сортировка ключей
            String[] keys1 = data1.keySet().toArray(new String[0]);
            String[] keys2 = data2.keySet().toArray(new String[0]);
            Arrays.sort(keys1);
            Arrays.sort(keys2);

            // Обработка ключей из data1
            for (String key : keys1) {
                if (!data2.containsKey(key)) {
                    diff.append("  - ").append(key).append(": ").append(data1.get(key)).append("\n");
                } else if (!data1.get(key).equals(data2.get(key))) {
                    diff.append("  - ").append(key).append(": ").append(data1.get(key)).append("\n");
                    diff.append("  + ").append(key).append(": ").append(data2.get(key)).append("\n");
                } else {
                    diff.append("    ").append(key).append(": ").append(data1.get(key)).append("\n");
                }
            }

            // Обработка ключей, которые есть только в data2
            for (String key : keys2) {
                if (!data1.containsKey(key)) {
                    diff.append("  + ").append(key).append(": ").append(data2.get(key)).append("\n");
                }
            }

            diff.append("}");
            return diff.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error parsing files", e);
        }
    }
}
