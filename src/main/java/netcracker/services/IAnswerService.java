package netcracker.services;

import netcracker.domain.entities.Answer;

import java.util.List;

/**
 * Created by Yaroslav on 21.02.2017.
 */
public interface IAnswerService {

    List<Answer> findAnswersByQuestionID(Long id);

}
