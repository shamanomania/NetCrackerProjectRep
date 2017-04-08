package netcracker.domain.entities;

import javax.persistence.*;
import java.io.Serializable;
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
    private int age;//Примитив не даёт установить null значение и устанавливает значение по умолчанию. Менять?

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

    @Column(name = "roleEnum")//for enumeration role type.....................................
    @Enumerated(EnumType.STRING)//for enumeration role type
    private RoleEnum roleEnum;//for enumeration role type

    @ManyToOne(cascade = CascadeType.MERGE)/*(fetch = FetchType.LAZY)*/
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

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    //public Long getCompanyId() {return companyId;}

    //public void setCompanyId(Long companyId) {this.companyId = companyId;}

    //public int getRole() {return roleId;}

    //public void setRole(int roleId) {this.roleId = roleId;}

    public Role getRole() {return role;}

    public void setRole(Role role) {this.role = role;}

    public RoleEnum getRoleEnum() {return roleEnum;} //for enumeration role type..........................................

    public void setRoleEnum(RoleEnum roleEnum) {this.roleEnum = roleEnum;}//for enumeration role type.................

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (sex != person.sex) return false;
        if (id != null ? !id.equals(person.id) : person.id != null) return false;
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
        if (address != null ? !address.equals(person.address) : person.address != null) return false;
        if (education != null ? !education.equals(person.education) : person.education != null) return false;
        if (mail != null ? !mail.equals(person.mail) : person.mail != null) return false;
        if (password != null ? !password.equals(person.password) : person.password != null) return false;
        if (company != null ? !company.equals(person.company) : person.company != null) return false;
        if (roleEnum != person.roleEnum) return false;
        if (role != null ? !role.equals(person.role) : person.role != null) return false;
        return persons != null ? persons.equals(person.persons) : person.persons == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + sex;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (roleEnum != null ? roleEnum.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (persons != null ? persons.hashCode() : 0);
        return result;
    }
}
