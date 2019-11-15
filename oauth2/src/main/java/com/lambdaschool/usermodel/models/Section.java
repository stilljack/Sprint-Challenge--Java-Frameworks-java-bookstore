package com.lambdaschool.usermodel.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.usermodel.logging.Loggable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Loggable
@Entity
@Table(name = "section")
public class Section extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sectionid;

    @Column(nullable = false,
            unique = true)
    private String name;
    @OneToMany(mappedBy = "section",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("section")
    private List<Books> books = new ArrayList<>();
 /*   section

    sectionid - long primary key
    sectionname - String the name of section. Cannot be null. Must be unique*/

    public long getSectionid() {
        return sectionid;
    }

    public void setSectionid(long sectionid) {
        this.sectionid = sectionid;
    }

    public String getSectionname() {
        return name;
    }

    public Section() {
    }

    public void setSectionname(String sectionname) {
        this.name = sectionname;
    }

}

