package netcracker.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TEST")
public class Test {

    @Id
    @Column (name = "ID")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;


    @ManyToMany
    @JoinTable(
            name = "CertificateTest",
            joinColumns = @JoinColumn(name = "certificate_id"),
            inverseJoinColumns = @JoinColumn(name = "test_id"))
    private List<Certificate> certificates;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany(mappedBy = "tests",cascade = CascadeType.ALL)
    private List<Question> questions;

    @OneToMany(mappedBy = "tests")
    private List<Test> tests;

    @OneToOne
    @JoinColumn(name = "image_id",referencedColumnName = "id")
    private Images image;

//    @ManyToOne
//    @JoinColumns({
//            @JoinColumn(name = "person_id"),
//            @JoinColumn(name = "test_id")
//    })
//    private PersonTest personTest;

    public Test(){}

    public Test(String title) {
        this.title = title;
    }

    public Long getId(){return id;}

    public void setId(Long id){this.id = id;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(Images image){
        this.image=image;
    }

    public Images getImage(){
        return image;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", certificates=" + certificates +
                ", questions=" + questions +
                '}';
    }
}
