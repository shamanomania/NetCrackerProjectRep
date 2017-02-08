package netcracker.domain.entities;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;

/**
 * Created by Sid775 on 02.02.2017.
 */
@Entity
public class Person {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String FirstName;

    @Column
    private String Name;

    @Column
    private String LastName;

    @Column
    private int Age;

    @Column
    private int Sex;

    @Column
    private String Address;

    @Column
    private String Education;

    @Column
    private String Email;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    //foreyn key?
    @Column
    private Long company_id;
//    @ManyToOne
//    @JoinColumn(name = "Company_id")
//    private Company getCompany() {
//        return company;
//    }

    @Column
    private int RoleId;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getFirstName() {return FirstName;}

    public void setFirstName(String firstName) {FirstName = firstName;}

    public String getName() {return Name;}

    public void setName(String name) {Name = name;}

    public String getLastName() {return LastName;}

    public void setLastName(String lastName) {LastName = lastName;}

    public int getAge() {return Age;}

    public void setAge(int age) {Age = age;}

    public int getSex() {return Sex;}

    public void setSex(int sex) {Sex = sex;}

    public String getAddress() {return Address;}

    public void setAddress(String address) {Address = address;}

    public String getEducation() {return Education;}

    public void setEducation(String education) {Education = education;}

    public String getEmail() {return Email;}

    public void setEmail(String email) {Email = email;}

    //public Long getCompanyId() {return companyId;}

    //public void setCompanyId(Long companyId) {this.companyId = companyId;}

    public int getRoleId() {return RoleId;}

    public void setRoleId(int roleId) {RoleId = roleId;}
}
