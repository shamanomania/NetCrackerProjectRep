package netcracker.viewsForms;

import netcracker.domain.entities.Question;
import netcracker.domain.entities.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Sid775 on 01.05.2017.
 */
public class TestForm {

    @Autowired
    private Test test;

    private Long id;

    private List<Question> questions;

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
