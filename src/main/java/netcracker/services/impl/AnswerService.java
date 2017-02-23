package netcracker.services.impl;

import netcracker.domain.entities.Answer;
import netcracker.repository.AnswerRepository;
import netcracker.services.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by Yaroslav on 21.02.2017.
 */
@Service
public class AnswerService implements IAnswerService {

    private AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        Assert.notNull(answerRepository);
        this.answerRepository = answerRepository;
    }

    @Override
    public List<Answer> findAnswersByQuestionID(Long id) {
        return answerRepository.findAnswersByQuestionID(id);
    }

}
