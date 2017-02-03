package netcracker.domain.entities;

import oracle.sql.BLOB;

import javax.persistence.*;

/**
 * Created by Sid775 on 02.02.2017.
 */
@Entity
public class Images {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private BLOB Image;
}
