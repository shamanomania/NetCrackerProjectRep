package netcracker.services;

import netcracker.domain.entities.Question;

import java.util.List;

/**
 * Created by Sid775 on 11.02.2017.
 */
public interface IQuestionService {

    public Question findByTitle(String title);

    public List<Question> getAll();

    public Question getFirst();

}
