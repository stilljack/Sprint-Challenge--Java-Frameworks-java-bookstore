package com.lambdaschool.usermodel.models;

import com.lambdaschool.usermodel.logging.Loggable;

import javax.persistence.*;

@Loggable
@Entity
@Table(name = "section")
public class Section extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sectionid;

    @Column(nullable = false,
            unique = true)
    private String sectionname;
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
        return sectionname;
    }

    public void setSectionname(String sectionname) {
        this.sectionname = sectionname;
    }
}

