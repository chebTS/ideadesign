package ua.com.idea.utils;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cheb on 12/8/15.
 */
public class CustomJsonDateDeserializer extends JsonDeserializer<Date>
{
    @Override
    public Date deserialize(JsonParser jsonparser,
                            DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {

        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        //2015-12-04 09:19:46
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String date = jsonparser.getText();
        try {
            return format.parse(date);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}