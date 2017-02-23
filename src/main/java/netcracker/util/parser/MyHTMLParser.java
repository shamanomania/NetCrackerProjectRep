package netcracker.util.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav on 09.02.2017.
 */
public class MyHTMLParser implements MyParser {

    private Document document;

    private MyHTMLParser(Document document) {
        this.document = document;
    }

    public static MyParser getParser(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        return new MyHTMLParser(document);
    }

    private Elements parseElement(Element e, String type, String value) {
        Elements elements;

        switch (type) {
            case "tag":
                elements = e.getElementsByTag(value);
                break;
            case "id":
                elements = new Elements(e.getElementById(value));
                break;
            case "class":
                elements = e.getElementsByClass(value);
                break;
            case "attribute":
                elements = e.getElementsByAttribute(value);
                break;
            default:
                elements = new Elements();
        }

        return elements;
    }

    @Override
    public List<String> parse(List<Node> structure) {
        if (structure.size() == 0) {
            return new ArrayList<>(0);
        }

        Elements elements = this.document.getElementsByTag("body");

        for (Node node : structure) {
            Elements parsedElements = new Elements();
            for (Element e : elements) {
                parsedElements.addAll(parseElement(e, node.getType(), node.getValue()));
            }
            elements = parsedElements;
        }

        List<String> result = new ArrayList<>(elements.size());
        for (Element e : elements) {
            result.add(e.text());
        }

        return result;
    }

}
