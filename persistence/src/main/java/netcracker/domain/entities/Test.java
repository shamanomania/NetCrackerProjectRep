package netcracker.domain.entities;

import javax.persistence.*;

/**
 * Created by Sid775 on 02.02.2017.
 */
@Entity
@Table(name = "TEST")
public class Test {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    public Test(){}

    public Test(Long id){
        this.id = id;
    }

    public Long getId(){return id;}

    public void setId(){this.id = id;}

}
