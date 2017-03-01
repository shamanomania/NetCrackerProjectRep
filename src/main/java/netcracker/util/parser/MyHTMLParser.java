package netcracker.util.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

/**
 * Created by Yaroslav on 26.02.2017.
 */
public class MyHTMLParser {

    private Elements elements;

    public MyHTMLParser(Element... elements) {
        this.elements = new Elements(elements);
    }

    public static MyHTMLParser getParser(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        return new MyHTMLParser(document.body());
    }

    public void setElements(Element... elements) {
        this.elements = new Elements(elements);
    }

    private Elements parseElement(Element element, Data data) {
        Elements elements;
        String type = data.getType();
        String value = data.getValue();

        switch (type) {
            case "tag":
                elements = element.getElementsByTag(value);
                break;
            case "id":
                elements = new Elements(element.getElementById(value));
                break;
            case "class":
                elements = element.getElementsByClass(value);
                break;
            case "attribute":
                elements = element.getElementsByAttribute(value);
                break;
            default:
                elements = new Elements();
        }

        return elements;
    }

    public Elements parse(List<Data> structure) {
        if (structure.size() == 0) {
            return new Elements(0);
        }

        Elements parsed = this.elements;

        for (Data data : structure) {
            Elements parsedElements = new Elements();
            for (Element e : parsed) {
                parsedElements.addAll(parseElement(e, data));
            }
            parsed = parsedElements;
        }

        return parsed;
    }

}
