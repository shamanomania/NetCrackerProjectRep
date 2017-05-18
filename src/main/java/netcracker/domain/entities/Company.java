package netcracker.domain.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Sid775 on 02.02.2017.
 */
@Entity
@Table (name = "COMPANY")
public class Company {

    @Id
    @Column (name = "ID")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "TITLE")
    private String title;

    @Column (name = "ADDRESS")
    private String address;


    @ManyToMany
    @JoinTable(
            name = "CertificateCompany",
            joinColumns=@JoinColumn(name = "certificate_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    private List<Certificate> certificates;

//    @ManyToMany
//    @JoinTable(
//            name = "Person",
//            joinColumns=@JoinColumn(name = "PersonId", referencedColumnName = "ID"),
//            inverseJoinColumns=@JoinColumn(name = "CompanyId", referencedColumnName = "ID"))
//    private List<Person> persons;

    @OneToMany(mappedBy = "company")
    private List<Test> tests;

    @OneToMany(mappedBy = "company")//Маппинг происходит на поле(не нейм)
    private List<Person> persons;

    public Company(){}

    public Company(String title,String address){this.title = title; this.address = address;}

    public Long getId(){return id;}

    public void setId(Long id){this.id = id;}

    public String getTitle(){return title;}

    public void setTitle(String title){this.title = title;}

    public String getAddress(){return address;}

    public void setAddress(String address){this.address = address;}
}
