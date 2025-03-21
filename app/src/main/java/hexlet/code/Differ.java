package hexlet.code;

import hexlet.code.formatters.Formatter;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.Map;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {

        String content1 = Files.readString(Paths.get(filepath1));
        String content2 = Files.readString(Paths.get(filepath2));

        String dataType = getDataType(filepath1);

        Map<String, Object> data1 = Parser.parse(content1, dataType);
        Map<String, Object> data2 = Parser.parse(content2, dataType);

        Map<String, Map<String, Object>> diff = DiffBuilder.buildDiff(data1, data2);

        return Formatter.format(diff, format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    private static String getDataType(String filepath) {
        if (filepath.endsWith(".json")) {
            return "json";
        } else if (filepath.endsWith(".yaml") || filepath.endsWith(".yml")) {
            return "yaml";
        } else {
            throw new IllegalArgumentException("Unsupported file type: " + filepath);
        }
    }
}
