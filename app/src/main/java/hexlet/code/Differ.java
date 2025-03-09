package hexlet.code;

import java.util.Map;

public class Differ {

    public static String generate(String filepath1, String filepath2) {
        try {
            Map<String, Object> data1 = JsonParser.parseJson(filepath1);
            Map<String, Object> data2 = JsonParser.parseJson(filepath2);

            StringBuilder diff = new StringBuilder();
            diff.append("{\n");

            for (String key : data1.keySet()) {
                if (!data2.containsKey(key)) {
                    diff.append("  - ").append(key).append(": ").append(data1.get(key)).append("\n");
                } else if (!data1.get(key).equals(data2.get(key))) {
                    diff.append("  - ").append(key).append(": ").append(data1.get(key)).append("\n");
                    diff.append("  + ").append(key).append(": ").append(data2.get(key)).append("\n");
                } else {
                    diff.append("    ").append(key).append(": ").append(data1.get(key)).append("\n");
                }
            }

            for (String key : data2.keySet()) {
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

