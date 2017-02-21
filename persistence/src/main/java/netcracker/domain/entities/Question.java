package netcracker.domain.entities;


import javax.persistence.*;
import java.util.List;

/**
 * Created by Sid775 on 02.02.2017.
 */
@Entity
@Table (name = "QUESTION")
public class Question {

    @Id
    @Column (name = "ID")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "TITLE")
    private String title;

    @Column (name = "ANSWER")
    private String answer;

    @ManyToMany
    @JoinTable(
            name = "TestQuestion",
            joinColumns =@JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "test_id"))
    private List<Test> tests;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getAnswer() {return answer;}

    public void setAnswer(String answer) {this.answer = answer;}
}
