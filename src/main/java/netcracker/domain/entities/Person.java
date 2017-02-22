package netcracker.domain.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Sid775 on 02.02.2017.
 */
@Entity
@Table (name = "PERSON")
public class Person {

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
    private int age;

    @Column (name = "SEX")
    private int sex;

    @Column (name = "ADDRESS")
    private String address;

    @Column (name = "EDUCATION")
    private String education;

    @Column (name = "MAIL")
    private String mail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

//    @ManyToOne
//    @JoinColumns({
//            @JoinColumn(name = "person_id"),
//            @JoinColumn(name = "test_id")
//    })
//    private PersonTest personTest;

    @OneToMany(mappedBy = "persons")
    private List<Person> persons;

    //foreyn key?
    //@Column
    //private Long company_id;
//    @ManyToOne
//    @JoinColumn(name = "Company_id")
//    private Company getCompany() {
//        return company;
//    }

    //@Column
    //private int roleId;

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

    //public Long getCompanyId() {return companyId;}

    //public void setCompanyId(Long companyId) {this.companyId = companyId;}

    //public int getRoleId() {return roleId;}

    //public void setRoleId(int roleId) {this.roleId = roleId;}
}
