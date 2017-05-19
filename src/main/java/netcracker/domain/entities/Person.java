package netcracker.domain.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sid775 on 02.02.2017.
 */
@Entity
@Table (name = "PERSON")
public class Person implements Serializable {

    @Id
    @Column (name = "ID")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "FIRST_NAME")
    private String firstName;

    @Column (name = "NAME")
    private String name;

    @Column (name = "LAST_NAME")
    private String lastName;

    @Column (name = "AGE")
    private Integer age;

    @Column (name = "SEX")
    private int sex;

    @Column (name = "ADDRESS")
    private String address;

    @Column (name = "EDUCATION")
    private String education;

    @Column (name = "MAIL")
    private String mail;

    @Column
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(cascade = CascadeType.MERGE)/*(fetch = FetchType.LAZY)*/
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "persons")
    private List<Person> persons;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public int getAge() {return age;}

    public void setAge(int age) {this.age = age;}

    public int getSex() {return sex;}

    public void setSex(int sex) {this.sex = sex;}

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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", education='" + education + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", company=" + company +
                ", role=" + role +
                '}';
    }
}
