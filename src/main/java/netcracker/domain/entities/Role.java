package netcracker.domain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Sid775 on 02.02.2017.
 */
@Entity
@Table (name = "ROLE")
public class Role implements Serializable {

    @Id
    @Column (name = "ID")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "TITLE")
    private String title;

    @OneToMany(mappedBy = "role")//Маппинг происходит на поле(не нейм)
    private List<Person> persons;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}
}
