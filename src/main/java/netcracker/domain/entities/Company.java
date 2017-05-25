package netcracker.domain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table (name = "COMPANY")
public class Company implements Serializable{

    @Id
    @Column (name = "ID")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "NAME")
    private String name;

    @Column (name = "TITLE")
    private String title;

    @Column (name = "ADDRESS")
    private String address;


    /*@ManyToMany
    @JoinTable(
            name = "CertificateCompany",
            joinColumns=@JoinColumn(name = "certificate_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    private List<Certificate> certificates;*/

    @OneToMany(mappedBy = "company")
    private List<Certificate> certificates;

//    @ManyToMany
//    @JoinTable(
//            name = "Person",
//            joinColumns=@JoinColumn(name = "PersonId", referencedColumnName = "ID"),
//            inverseJoinColumns=@JoinColumn(name = "CompanyId", referencedColumnName = "ID"))
//    private List<Person> persons;

    @OneToMany(mappedBy = "company")
    private List<Test> tests;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Images image;

    @OneToMany(mappedBy = "company")//Маппинг происходит на поле(не нейм)
    private List<Person> persons;

    public Company(){}

    public Company(String title,String address){this.title = title; this.address = address;}

    public Long getId(){return id;}

    public void setId(Long id){this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle(){return title;}

    public void setTitle(String title){this.title = title;}

    public String getAddress(){return address;}

    public void setAddress(String address){this.address = address;}

    /*public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }*/

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
