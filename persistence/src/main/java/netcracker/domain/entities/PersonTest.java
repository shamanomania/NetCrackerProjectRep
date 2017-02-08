package netcracker.domain.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by Sid775 on 09.02.2017.
 */
@Entity
public class PersonTest {
    @EmbeddedId
    private PersonTestId id;

    @Column
    private Date dateOfTest;

    @Column
    private String result;

    @OneToMany(mappedBy = "personTest")
    private List<Person> persons;

    @OneToMany(mappedBy = "personTest")
    private List<Test> tests;

    public PersonTestId getId() {return id;}

    public void setId(PersonTestId id) {this.id = id;}

    public Date getDate() {return dateOfTest;}

    public void setDate(Date date) {this.dateOfTest = date;}

    public String getResult() {return result;}

    public void setResult(String result) {this.result = result;}
}
