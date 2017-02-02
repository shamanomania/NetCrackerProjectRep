package netcracker.domain.entities;

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

    @Column
    private int CompanyId;

    @Column
    private int RoleId;
}
