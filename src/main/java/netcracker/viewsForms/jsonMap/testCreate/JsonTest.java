package netcracker.viewsForms.jsonMap.testCreate;

import java.util.List;

/**
 * Created by Sid775 on 08.05.2017.
 */
public class JsonTest {

    private List<JsonQuestion> questions;
    private String titleOfTest;

    public List<JsonQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<JsonQuestion> questions) {
        this.questions = questions;
    }

    public String getTitleOfTest() {
        return titleOfTest;
    }

    public void setTitleOfTest(String titleOfTest) {
        this.titleOfTest = titleOfTest;
    }

    @Override
    public String toString() {
        return "JsonTest{" +
                "questions=" + questions +
                ", titleOfTest='" + titleOfTest + '\'' +
                '}';
    }
}
