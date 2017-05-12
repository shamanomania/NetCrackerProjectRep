package netcracker.viewsForms.jsonMap.test;

import java.util.Arrays;

/**
 * Created by Sid775 on 11.05.2017.
 */
public class JsonResponse {

    private String result;
    private JsonResponseAnswer[] answers;
    private JsonResponseCorrectAnswer[] correctAnswers;


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public JsonResponseAnswer[] getAnswers() {
        return answers;
    }

    public void setAnswers(JsonResponseAnswer[] answers) {
        this.answers = answers;
    }

    public JsonResponseCorrectAnswer[] getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(JsonResponseCorrectAnswer[] correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    @Override
    public String toString() {
        return "JsonResponse{" +
                "result='" + result + '\'' +
                ", answers=" + Arrays.toString(answers) +
                ", correctAnswers=" + Arrays.toString(correctAnswers) +
                '}';
    }
}
