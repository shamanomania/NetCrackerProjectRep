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

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "TYPE", nullable = false)
    private String type;

    @ManyToMany
    @JoinTable(
            name = "TestQuestion",
            joinColumns =@JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "test_id"))
    private List<Test> tests;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers;

    @ManyToMany
    @JoinTable(
            name = "CorrectAnswer",
            joinColumns =@JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "answer_id"))
    private List<Answer> correctAnswers;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
