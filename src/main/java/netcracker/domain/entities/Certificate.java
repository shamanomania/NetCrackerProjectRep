package netcracker.domain.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Sid775 on 02.02.2017.
 */
@Entity
@Table (name = "CERTIFICATE")
public class Certificate {

    @Id
    @Column (name = "ID")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "TITLE")
    private String title;

    @ManyToMany(mappedBy = "certificates")
    private List<Test> tests;

    /*@ManyToMany(mappedBy = "certificates")
    private List<Company> companies;*/

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Certificate(){}

    public Certificate(String title){
        this.title = title;
    }

    public Long getId(){return id;}

    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){return title;}

    public void setTitle(String title){
        this.title = title;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

   /* public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }*/

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
