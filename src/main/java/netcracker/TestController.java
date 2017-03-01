package netcracker;

import netcracker.domain.entities.Answer;
import netcracker.domain.entities.Question;
import netcracker.parser.IndiaBixParser;
import netcracker.parser.TestParser;
import netcracker.services.IAnswerService;
import netcracker.services.IQuestionService;
import netcracker.services.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yaroslav on 27.02.2017.
 */
@RestController
public class TestController {

    private ITestService testService;
    private IQuestionService questionService;
    private IAnswerService answerService;

    @Autowired
    public TestController(ITestService testService, IQuestionService questionService, IAnswerService answerService) {
        Assert.notNull(testService);
        Assert.notNull(questionService);
        Assert.notNull(answerService);

        this.testService = testService;
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @RequestMapping("/tests")
    public String loadTests() {
        TestParser parser = new IndiaBixParser();
        HashMap<Question, List<Answer>> qaMap = parser.parse("http://www.indiabix.com/online-test/java-programming-test/61");
        for (Map.Entry<Question, List<Answer>> qa : qaMap.entrySet()) {
            questionService.save(qa.getKey());
        }

        return "Check DB!";
    }

}
