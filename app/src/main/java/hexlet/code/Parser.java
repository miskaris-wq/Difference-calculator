package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Parser {
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    private static final ObjectMapper YAML_MAPPER = new ObjectMapper(new YAMLFactory());

    public static Map<String, Object> parse(String filePath) throws IOException {
        File file = new File(filePath);
        return file.getName().endsWith(".yml") || file.getName().endsWith(".yaml")
                ? YAML_MAPPER.readValue(file, new TypeReference<>() { })
                : JSON_MAPPER.readValue(file, new TypeReference<>() { });
    }
}
