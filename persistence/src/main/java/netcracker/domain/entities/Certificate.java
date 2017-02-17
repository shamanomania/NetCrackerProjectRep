package netcracker.domain.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Sid775 on 02.02.2017.
 */
@Entity
public class Certificate {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @ManyToMany(mappedBy = "certificates")
    private List<Test> tests;

    @ManyToMany(mappedBy = "certificates")
    private List<Company> companies;

    public Certificate(){}

    public Certificate(String title){
        this.title = title;
    }

    public Long getId(){return id;}

    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){return title;}

    public void setTitle(String title){
        this.title = title;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "id=" + id +
                ", title='" + title +
                '}';
    }

}
