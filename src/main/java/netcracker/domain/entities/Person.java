package netcracker.domain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "PERSON")
public class Person implements Serializable {

    @Id
    @Column (name = "ID")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "FIRST_NAME")
    private String firstName;

    @Column (name = "LAST_NAME")
    private String lastName;

    @Column (name = "ADDRESS")
    private String address;

    @Column (name = "EDUCATION")
    private String education;

    @Column (name = "MAIL")
    private String mail;

    @Column
    private String password;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(cascade = CascadeType.MERGE)/*(fetch = FetchType.LAZY)*/
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "PersonCertificate",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "certificate_id")
    )
    private List<Certificate> certificates;


    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}


    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public String getEducation() {return education;}

    public void setEducation(String education) {this.education = education;}

    public String getEmail() {return mail;}

    public void setEmail(String email) {this.mail = email;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public Role getRole() {return role;}

    public void setRole(Role role) {this.role = role;}

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", education='" + education + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", company=" + company +
                ", role=" + role +
                '}';
    }
}
