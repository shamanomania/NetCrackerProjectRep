package netcracker.parser;

import netcracker.domain.entities.Answer;
import netcracker.domain.entities.Question;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Yaroslav on 28.02.2017.
 */
public class IndiaBixParser implements TestParser {

    private final static int codeA = Integer.parseInt(String.valueOf("A".getBytes()[0]));

    private Answer extractCorrectAnswer(List<Answer> answers, String correctOption) {
        return answers.get(Integer.parseInt(String.valueOf(correctOption.getBytes()[0])) - codeA);
    }

    @Override
    public HashMap<Question, List<Answer>> parse(String qaURL, String correctAnswersURL) {
        Document document;
        try {
            document = Jsoup.connect(qaURL).get();
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>(0);
        }

        HashMap<Question, List<Answer>> qaMap = new HashMap<>();

        Elements qaElements = document.body().getElementsByClass("bix-tbl-container");
        for (Element qa : qaElements) {
            String title = qa.getElementsByClass("bix-td-qtxt").text();
            String type = qa.getElementsByTag("input").first().attr("type");

            Question question = new Question(title, type);

            List<Answer> answers = new ArrayList<>();
            Elements answerElements = qa.getElementsByClass("bix-inner-td-option");
            for (Element a : answerElements) {
                answers.add(new Answer(a.text(), question));
            }

            Elements correctAnswersElements = qa.getElementsByClass("ib-dgray ib-bold");
            List<Answer> correctAnswers = new ArrayList<>();
            for (Element ca : correctAnswersElements) {
                correctAnswers.add(extractCorrectAnswer(answers, ca.text()));
            }

            question.setAnswers(answers);
            question.setCorrectAnswers(correctAnswers);

            qaMap.put(question, answers);

//            System.out.println(question.toString());
        }

        return qaMap;
    }

}
