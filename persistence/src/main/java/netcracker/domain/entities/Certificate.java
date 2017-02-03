package netcracker.domain.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Sid775 on 02.02.2017.
 */
@Entity
public class Certificate {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String Title;

    @ManyToMany
    @JoinTable(
            name = "TEST",
            joinColumns = @JoinColumn(name = "TestId", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "CertificateId", referencedColumnName = "ID"))
    private List<Test> tests;

    public Certificate(){}

    public Certificate(String Title){
        this.Title = Title;
    }

    public Long getId(){return id;}

    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){return Title;}

    public void setTitle(String title){
        this.Title = Title;
    }

    public List<Test> getTests(){
        return tests;
    }

    public void setTests(List<Test> tests){
        this.tests = tests;
    }



}
