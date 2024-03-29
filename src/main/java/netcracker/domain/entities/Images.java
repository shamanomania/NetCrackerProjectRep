package netcracker.domain.entities;

import netcracker.viewsForms.validator.FieldEquals;
import oracle.sql.BLOB;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Sid775 on 02.02.2017.
 */
@Entity
@Table (name = "IMAGES")
public class Images implements Serializable {

    @Id
    @Column (name = "ID")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    @Column (name = "IMAGE")
    private byte[] image;

    @OneToMany
    @JoinColumn(name = "test_id")
    private List<Test> tests;

    @OneToMany(mappedBy = "image")
    private List<Company> companies;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public byte[] getImage() {return image;}

    public void setImage(byte[] image) {this.image = image;}

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

}
