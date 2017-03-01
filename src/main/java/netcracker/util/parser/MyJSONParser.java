package netcracker.util.parser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav on 26.02.2017.
 */
public class MyJSONParser {

    private Object jsonData;

    public MyJSONParser(Object jsonData) {
        this.jsonData = jsonData;
    }

    public static MyJSONParser getParser(String url) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object jsonData = parser.parse(new InputStreamReader(new URL(url).openStream()));
        return new MyJSONParser(jsonData);
    }

    private static Object getProperty(Object object, String property) {
        return ((JSONObject) object).get(property);
    }

    private List<Object> parseElement(Object object, Data data) {
        String type = data.getType();
        String value = data.getValue();
        List<Object> result = new ArrayList<>();

        switch (type) {
            case "object":
                if (value.isEmpty()) {
                    result.add(object);
                } else {
                    result.add(getProperty(object, value));
                }
                break;
            case "array":
                JSONArray array = (JSONArray) object;
                if (value.isEmpty()) {
                    result.addAll(array);
                } else for (Object obj : array) {
                    result.add(getProperty(obj, value));
                }
                break;
            case "property":
                result.add(getProperty(object, value));
        }

        return result;
    }

    public List<Object> parse(List<Data> structure) {
        if (structure.size() == 0) {
            return new ArrayList<>(0);
        }

        List<Object> parsed = new ArrayList<>();
        parsed.add(jsonData);

        for (Data data : structure) {
            List<Object> list = new ArrayList<>();
            for (Object obj : parsed) {
                list.addAll(parseElement(obj, data));
            }
            parsed = list;
        }

        return parsed;
    }

}
