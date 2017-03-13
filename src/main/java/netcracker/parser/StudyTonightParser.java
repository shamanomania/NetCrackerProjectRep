package netcracker.parser;

import netcracker.domain.entities.Answer;
import netcracker.domain.entities.Question;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Yaroslav on 27.02.2017.
 */
public class StudyTonightParser implements TestParser {

    @Override
    public HashMap<Question, List<Answer>> parse(String qaURL, String correctAnswersURL) {
        Document document;
        Object jsonData;
        try {
            document = Jsoup.connect(qaURL).get();
            jsonData = new JSONParser().parse(new InputStreamReader(new URL(correctAnswersURL).openStream()));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return new HashMap<>(0);
        }

        HashMap<Question, List<Answer>> qaMap = new HashMap<>();

        Elements qaElements = document.body().getElementsByClass("quiz_content");
        JSONArray jsonArray = (JSONArray) jsonData;
        Iterator jsonObjectIterator = jsonArray.iterator();
        for (Element qa : qaElements) {
            String title = qa.getElementsByClass("quiz_question").text();
            String type = qa.getElementsByTag("input").first().attr("type");

            Question question = new Question(title, type);

            List<Answer> answers = new ArrayList<>();
            Elements answerElements = qa.getElementsByClass("quiz_options").first().getElementsByTag("label");
            for (Element a : answerElements) {
                answers.add(new Answer(a.text(), question));
            }

            String correctAnswer = String.valueOf(((JSONObject) jsonObjectIterator.next()).get("answer"));

            List<Answer> correctAnswers = new ArrayList<>(1);
            correctAnswers.add(new Answer(correctAnswer, question));

            question.setAnswers(answers);
            question.setCorrectAnswers(correctAnswers);

//            System.out.println(question.toString());
        }

        return qaMap;
    }

}
