package se.alex.lexicon.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> void serializeToJsonFile(String filePath, T object) throws IOException {
        objectMapper.writeValue(new File(filePath), object);
    }

    public static <T> T deserializeFromJsonFile(String filePath, Class<T> clazz) throws IOException {
        return objectMapper.readValue(new File(filePath), clazz);
    }
}
