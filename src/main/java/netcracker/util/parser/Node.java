package netcracker.util.parser;

/**
 * Created by Yaroslav on 11.02.2017.
 */
public class Node {

    private String type;
    private String value;

    public Node(String type, String value) {
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
