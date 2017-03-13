package netcracker.parser;

import netcracker.domain.entities.Answer;
import netcracker.domain.entities.Question;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Yaroslav on 27.02.2017.
 */
public interface TestParser {

    default HashMap<Question, List<Answer>> parse(String qaURL) {
        return parse(qaURL, qaURL);
    }

    HashMap<Question, List<Answer>> parse(String qaURL, String correctAnswersURL);

}
