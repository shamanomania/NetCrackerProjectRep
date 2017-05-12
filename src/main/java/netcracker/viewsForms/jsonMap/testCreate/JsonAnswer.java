package netcracker.viewsForms.jsonMap.testCreate;

/**
 * Created by Sid775 on 09.05.2017.
 */
public class JsonAnswer {

    private String answer;

    public JsonAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "JsonAnswer{" +
                "answer='" + answer + '\'' +
                '}';
    }
}
