package Features;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Helper {
    public static String getObjectAsString(Object object){
    String payload;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            payload=objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


        return payload;
    }
}
