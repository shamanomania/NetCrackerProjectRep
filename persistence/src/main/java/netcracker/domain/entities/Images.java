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

    @Column (name = "IMAGE")
    private BLOB image;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public BLOB getImage() {return image;}

    public void setImage(BLOB image) {this.image = image;}
}
