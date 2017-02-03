package netcracker.domain.entities;

import javax.persistence.*;

/**
 * Created by Sid775 on 02.02.2017.
 */
@Entity
public class Role {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String Title;
}
