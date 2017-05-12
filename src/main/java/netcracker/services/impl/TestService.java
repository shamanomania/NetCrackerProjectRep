package netcracker.services.impl;

import netcracker.domain.entities.Answer;
import netcracker.domain.entities.Question;
import netcracker.domain.entities.Test;
import netcracker.repository.TestRepository;
import netcracker.services.ITestService;
import netcracker.viewsForms.jsonMap.test.JsonResponse;
import netcracker.viewsForms.jsonMap.test.JsonResponseAnswer;
import netcracker.viewsForms.jsonMap.test.JsonResponseCorrectAnswer;
import netcracker.viewsForms.jsonMap.testCreate.JsonTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sid775 on 02.02.2017.
 */
@Service
public class TestService implements ITestService {

    private TestRepository testRepository;

    @Autowired
    public TestService(TestRepository testRepository){
        Assert.notNull(testRepository);
        this.testRepository = testRepository;
    }

    public Test createTest(JsonTest jsonTest){
        List<Test> tests = new ArrayList<>();
        Test test = new Test();
        tests.add(test);
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < jsonTest.getQuestions().size();i++) {
            if (jsonTest.getQuestions().get(i) != null) {
                Question question = new Question();
                List<Answer> answers = new ArrayList<>();
                question.setType(jsonTest.getQuestions().get(i).getType());
                question.setTitle(jsonTest.getQuestions().get(i).getQuestion());
                for (int j = 0; j < jsonTest.getQuestions().get(i).getAnswers().length; j++) {
                    Answer answer = new Answer();
                    if (j == Integer.parseInt(jsonTest.getQuestions().get(i).getRightAnswers())) {
                        List<Answer> correctAnswer = new ArrayList<>();
                        answer.setTitle(jsonTest.getQuestions().get(i).getAnswers()[j].getAnswer());
                        answer.setQuestion(question);
                        correctAnswer.add(answer);
                        question.setCorrectAnswers(correctAnswer);
                    } else if (!jsonTest.getQuestions().get(i).getAnswers()[j].getAnswer().equals("")) {
                        answer.setTitle(jsonTest.getQuestions().get(i).getAnswers()[j].getAnswer());
                        answer.setQuestion(question);
                        answers.add(answer);
                    }
                }
                question.setAnswers(answers);
                question.setTests(tests);
                questions.add(question);
            }
        }
        test.setQuestions(questions);
        test.setTitle(jsonTest.getTitleOfTest());

        System.out.println(test.toString());
        return testRepository.save(test);
    }

    public JsonResponse passTest(netcracker.viewsForms.jsonMap.test.JsonTest jsonTest){
        System.out.println(testRepository.findOne(jsonTest.getId()));
        Test test = testRepository.findOne(jsonTest.getId());
        JsonResponse jsonResponse = new JsonResponse();
        JsonResponseAnswer jsonResponseAnswers[] = new JsonResponseAnswer[jsonTest.getAnswers().length];
        JsonResponseCorrectAnswer jsonResponseCorrectAnswers[] = new JsonResponseCorrectAnswer[jsonTest.getAnswers().length];
        for (int i = 0; i < jsonTest.getAnswers().length; i++){
            JsonResponseAnswer answer = new JsonResponseAnswer();
            JsonResponseCorrectAnswer correctAnswer = new JsonResponseCorrectAnswer();
            answer.setId(jsonTest.getAnswers()[i].getAnswer());
            correctAnswer.setId(test.getQuestions().get(i).getCorrectAnswers().get(0).getId().toString());
            if (jsonTest.getAnswers()[i].getAnswer().equals(test.getQuestions().get(i).getCorrectAnswers().get(0).getTitle())){
                System.out.println("Верно: " + jsonTest.getAnswers()[i].getAnswer());
            }else {
                System.out.println("Неверно: " + jsonTest.getAnswers()[i].getAnswer() + "Верно: " + test.getQuestions().get(i).getCorrectAnswers().get(0).getTitle());
            }
            jsonResponseAnswers[i] = answer;
            jsonResponseCorrectAnswers[i] = correctAnswer;
        }
        jsonResponse.setAnswers(jsonResponseAnswers);
        jsonResponse.setCorrectAnswers(jsonResponseCorrectAnswers);
        return jsonResponse;
    }


}
