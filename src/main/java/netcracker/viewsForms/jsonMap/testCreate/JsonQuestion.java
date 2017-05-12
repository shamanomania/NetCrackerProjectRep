package netcracker.viewsForms.jsonMap.testCreate;

import java.util.Arrays;

/**
 * Created by Sid775 on 09.05.2017.
 */
public class JsonQuestion {

    private String question;
    private JsonAnswer[] answers;
    private String rightAnswers;
    private String type;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public JsonAnswer[] getAnswers() {
        return answers;
    }

    public void setAnswers(JsonAnswer[] answers) {
        this.answers = answers;
    }

    public String getRightAnswers() {
        return rightAnswers;
    }

    public void setRightAnswers(String rightAnswers) {
        this.rightAnswers = rightAnswers;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "JsonQuestion{" +
                "question='" + question + '\'' +
                ", answers=" + Arrays.toString(answers) +
                ", rightAnswers='" + rightAnswers + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
