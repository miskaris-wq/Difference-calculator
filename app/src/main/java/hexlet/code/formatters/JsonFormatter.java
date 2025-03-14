package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Map;

public class JsonFormatter {

    public static String format(Map<String, Object> data1, Map<String, Object> data2) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS);
        Map<String, Map<String, Object>> diff = DiffBuilder.buildDiff(data1, data2);
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(diff);
    }
}