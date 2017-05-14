package netcracker.viewsForms.jsonMap.test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Sid775 on 11.05.2017.
 */
public class JsonTest {

    private Long id;
    private JsonAnswer[] answers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JsonAnswer[] getAnswers() {
        return answers;
    }

    public void setAnswers(JsonAnswer[] answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "JsonTest{" +
                "id=" + id +
                ", answers=" + Arrays.toString(answers) +
                '}';
    }
}