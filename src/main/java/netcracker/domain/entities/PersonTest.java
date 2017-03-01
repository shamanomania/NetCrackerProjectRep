package netcracker.domain.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

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

    public Date getDate() {return dateOfTest;}

    public void setDate(Date date) {this.dateOfTest = date;}

    public String getResult() {return result;}

    public void setResult(String result) {this.result = result;}
}