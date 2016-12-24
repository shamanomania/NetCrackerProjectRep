package com.netcracker.domain.entities;

import javax.persistence.*;

@Entity
public class UserTest {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column
    private String name;

    public UserTest() {}

    public UserTest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
