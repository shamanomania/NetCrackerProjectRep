package netcracker.domain.entities;


import javax.persistence.*;

/**
 * Created by Sid775 on 02.02.2017.
 */
@Entity
public class Question {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String Title;

    @Column
    private String Answer;
}
