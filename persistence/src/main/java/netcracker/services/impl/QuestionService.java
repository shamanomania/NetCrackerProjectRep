package netcracker.services.impl;

import netcracker.domain.entities.Question;
import netcracker.repository.QuestionRepository;
import netcracker.services.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by Sid775 on 11.02.2017.
 */
public class QuestionService implements IQuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository){
        Assert.notNull(questionRepository);
        this.questionRepository = questionRepository;
    }

    @Override
    public Question findByTitle(String title) {
        return questionRepository.findByTitle(title);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question getFirst() {
        return questionRepository.findAll().iterator().next();
    }
}
