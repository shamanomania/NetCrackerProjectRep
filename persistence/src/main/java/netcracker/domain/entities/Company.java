package netcracker.domain.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Sid775 on 02.02.2017.
 */
@Entity
public class Company {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String Title;

    @Column
    private String Address;

    private Set<Person> personSet;

    @ManyToMany
    @JoinTable(
            name = "Certificate",
            joinColumns=@JoinColumn(name = "CertificateId", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "CompanyId", referencedColumnName = "ID"))
    private List<Certificate> certificates;

//    @ManyToMany
//    @JoinTable(
//            name = "Person",
//            joinColumns=@JoinColumn(name = "PersonId", referencedColumnName = "ID"),
//            inverseJoinColumns=@JoinColumn(name = "CompanyId", referencedColumnName = "ID"))
//    private List<Person> persons;

    @OneToMany(mappedBy = "company")//Маппинг происходит на поле(не нейм)
    private List<Person> persons;

    public Company(){}

    public Company(String Title,String Address){this.Title = Title; this.Address = Address;}

    public Long getId(){return id;}

    public void setId(Long id){this.id = id;}

    public String getTitle(){return Title;}

    public void setTitle(String Title){this.Title = Title;}

    public String getAddress(){return Address;}

    public void setAddress(String Address){this.Address = Address;}
}
