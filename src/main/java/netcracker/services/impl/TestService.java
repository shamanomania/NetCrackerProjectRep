package netcracker.services.impl;

import netcracker.domain.entities.*;
import netcracker.repository.PersonRepository;
import netcracker.repository.PersonTestRepository;
import netcracker.repository.TestRepository;
import netcracker.services.ITestService;
import netcracker.viewsForms.jsonMap.test.JsonResponse;
import netcracker.viewsForms.jsonMap.test.JsonResponseAnswer;
import netcracker.viewsForms.jsonMap.test.JsonResponseCorrectAnswer;
import netcracker.viewsForms.jsonMap.testCreate.JsonTest;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

    private final PersonTestRepository personTestRepository;

    private final PersonTestService personTestService;

    private final ImageService imageService;

    private final PersonRepository personRepository;

    @Autowired
    public TestService(TestRepository testRepository, PersonTestRepository personTestRepository, PersonTestService personTestService, ImageService imageService, PersonRepository personRepository){
        this.personRepository = personRepository;
        Assert.notNull(testRepository);
        this.testRepository = testRepository;
        this.personTestRepository = personTestRepository;
        this.personTestService = personTestService;
        this.imageService = imageService;
    }

    public Test createTest(JsonTest jsonTest){
        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
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
                question.setTest(test);
                System.out.println(question.getTest().toString());
                questions.add(question);
            }
        }
        test.setQuestions(questions);
        test.setTitle(jsonTest.getTitleOfTest());
        Images image = imageService.findTop();
        image.setTests(tests);
        test.setCompany(personRepository.findOne(currentUser.getId()).getCompany());
        test.setImage(image);
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
            correctAnswer.setId(test.getQuestions().get(i).getCorrectAnswers().get(0).getTitle());
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

    public JsonResponse testPassTest(netcracker.viewsForms.jsonMap.test.JsonTest jsonTest){
        Integer countOfAnswers;
        Integer countOfCorrectAnswers = 0;
        String resultOfTest;
        System.out.println(jsonTest.getcPartResult());
        String cPartResult = jsonTest.getcPartResult();

        System.out.println(testRepository.findOne(jsonTest.getId()));
        Test test = testRepository.findOne(jsonTest.getId());
        JsonResponse jsonResponse = new JsonResponse();
        JsonResponseAnswer jsonResponseAnswers[] = new JsonResponseAnswer[jsonTest.getAnswers().length];
        countOfAnswers = jsonTest.getAnswers().length;
        for (int i = 0; i < jsonTest.getAnswers().length; i++){
            JsonResponseAnswer answer = new JsonResponseAnswer();

            if (test.getQuestions().get(i).getType().equals("1")){
                if (jsonTest.getAnswers()[i].getAnswer().equals(test.getQuestions().get(i).getCorrectAnswers().get(0).getTitle())){
                    countOfCorrectAnswers++;
                }
                for (int j=0; j < test.getQuestions().get(i).getAnswers().size(); j++){//set chosen answer
                    if (test.getQuestions().get(i).getAnswers().get(j).getTitle().equals(jsonTest.getAnswers()[i].getAnswer())){
                        answer.setId(String.valueOf(j));
                    }
                }
                for (int j=0; j < test.getQuestions().get(i).getAnswers().size(); j++){//set correct answer
                    if (test.getQuestions().get(i).getCorrectAnswers().get(0).getTitle().equals(test.getQuestions().get(i).getAnswers().get(j).getTitle())){
                        answer.setId(answer.getId() + "," + j);
                    }
                }
            }else if (test.getQuestions().get(i).getType().equals("2")){
                if (jsonTest.getAnswers()[i].getAnswer().equals(test.getQuestions().get(i).getCorrectAnswers().get(0).getTitle())){//Form result is chosen correct
                    countOfCorrectAnswers++;
                    answer.setId("Верно: " + jsonTest.getAnswers()[i].getAnswer());
                }else {//Form result is chosen incorrect
                    answer.setId("Неверно: " + jsonTest.getAnswers()[i].getAnswer() + ", верный ответ: " + test.getQuestions().get(i).getCorrectAnswers().get(0).getTitle());
                }
            }else if (test.getQuestions().get(i).getType().equals("3")){
                if (jsonTest.getAnswers()[i].getAnswer().equals(test.getQuestions().get(i).getCorrectAnswers().get(0).getTitle())){//Form result is chosen correct
                    countOfCorrectAnswers++;
                    answer.setId("Верно!");
                }else {//Form result is chosen incorrect
                    answer.setId("Неверно!");
                }
            }
            System.out.println(answer.getId());
            jsonResponseAnswers[i] = answer;
        }
        jsonResponse.setAnswers(jsonResponseAnswers);
        System.out.println(countOfAnswers + "   " + countOfCorrectAnswers);
        resultOfTest = countOfCorrectAnswers + "/" + countOfAnswers;

        personTestRepository.save(personTestService.matchTestToUser(test,resultOfTest,cPartResult));

        addCertificateForUser(test);

        return jsonResponse;
    }

    private void addCertificateForUser(Test test) {
        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        boolean allTestPassed = true;

        Person person = currentUser.getUser();
        List<Certificate> certificates = new ArrayList<>();
        List<Person> users = new ArrayList<>();
        users.add(currentUser.getUser());
        for (Certificate certificatei : test.getCertificates()) {
            for (Test testi : certificatei.getTests()) {
                System.out.println("Результаты выбора из таблицы: " + personTestRepository.findByPersonIdAndTestId(currentUser.getUser().getId(),testi.getId()));
                if (personTestRepository.findByPersonIdAndTestId(currentUser.getUser().getId(),testi.getId()).size() == 0){
                    allTestPassed = false;
                    System.out.println("Id пользователя: " + currentUser.getUser().getId());
                    System.out.println("Id теста: " + testi.getId());
                }
            }
            if (allTestPassed == true){
                System.out.println("Сертификат для присвоения: " + certificatei);
                System.out.println("Кому присвоить: " + users);
                certificatei.setPersons(users);
                certificates.add(certificatei);//добавить сертификат к списку для выдачи
            }else {
                allTestPassed = true;
            }
        }
        person.setCertificates(certificates);//выдать все добавленные в список сертификаты
        personRepository.save(person);
    }


}
