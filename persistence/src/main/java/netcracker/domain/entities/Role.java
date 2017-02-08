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
    private String title;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}
}
