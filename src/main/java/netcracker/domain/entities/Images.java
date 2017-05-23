package netcracker.domain.entities;

import oracle.sql.BLOB;

import javax.persistence.*;

/**
 * Created by Sid775 on 02.02.2017.
 */
@Entity
@Table (name = "IMAGES")
public class Images {

    @Id
    @Column (name = "ID")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    @Column (name = "IMAGE")
    private byte[] image;

    @OneToOne
    @JoinColumn(name = "test_id",referencedColumnName = "id")
    private Test test;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public byte[] getImage() {return image;}

    public void setImage(byte[] image) {this.image = image;}
}
