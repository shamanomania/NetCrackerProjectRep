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
 * Created by Yaroslav on 09.02.2017.
 */
public class MyJSONParser implements MyParser {

    private Object jsonData;

    private MyJSONParser(Object jsonData) {
        this.jsonData = jsonData;
    }

    public static MyParser getParser(String url) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object jsonData = parser.parse(new InputStreamReader(new URL(url).openStream()));
        return new MyJSONParser(jsonData);
    }

    private static Object getProperty(Object jsonObj, String property) {
        return ((JSONObject) jsonObj).get(property);
    }

    private List<Object> parseJSONElement(Object object, String type, String value) {
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

    @Override
    public List<String> parse(List<Node> structure) {
        if (structure.size() == 0) {
            return new ArrayList<>(0);
        }

        List<Object> parsedJSON = new ArrayList<>();
        parsedJSON.add(jsonData);

        for (Node node : structure) {
            List<Object> list = new ArrayList<>();
            for (Object obj : parsedJSON) {
                list.addAll(parseJSONElement(obj, node.getType(), node.getValue()));
            }
            parsedJSON = list;
        }

        List<String> result = new ArrayList<>(parsedJSON.size());
        for (Object obj : parsedJSON) {
            result.add(String.valueOf(obj));
        }

        return result;
    }

}
