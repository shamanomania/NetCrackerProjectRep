package netcracker.domain.entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Sid775 on 09.02.2017.
 */
@Entity
@Table (name = "PERSON_TEST")
public class PersonTest {
    //@EmbeddedId
    //private PersonTestId id;
    @Id
    @Column (name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "DATE_OF_TEST")
    private Date dateOfTest;

    @Column (name = "RESULT")
    private String result;

    @Column (name = "CPartAnswer")
    private String cPartAnswer;

    //@OneToMany(mappedBy = "personTest")
    //private List<Person> persons;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private Test test;

    //@OneToMany(mappedBy = "personTest")
    //private List<Test> tests;

    //public PersonTestId getId() {return id;}

    //public void setId(PersonTestId id) {this.id = id;}


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Date getDate() {return dateOfTest;}

    public void setDate(Date date) {this.dateOfTest = date;}

    public String getResult() {return result;}

    public void setResult(String result) {this.result = result;}

    public String getcPartAnswer() {
        return cPartAnswer;
    }

    public void setcPartAnswer(String cPartAnswer) {
        this.cPartAnswer = cPartAnswer;
    }

    @Override
    public String toString() {
        return "PersonTest{" +
                "id=" + id +
                ", dateOfTest=" + dateOfTest +
                ", result='" + result + '\'' +
                ", person=" + person +
                ", test=" + test +
                '}';
    }
}
