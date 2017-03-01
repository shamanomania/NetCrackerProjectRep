package netcracker.util.parser;

/**
 * Created by Yaroslav on 26.02.2017.
 */
public class Data {

    private String type;
    private String value;

    public Data(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

}
