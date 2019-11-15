package com.lambdaschool.usermodel.models;

import com.lambdaschool.usermodel.logging.Loggable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Loggable
@Entity
@Table(name = "authors")
public class Authors extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    private String lastname;

    private String firstname;

@ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    List<Books> authorBooks=new ArrayList<>();

    public long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(long authorid) {
        this.authorid = authorid;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public List<Books> getAuthorBooks() {
        return authorBooks;
    }

    public void setAuthorBooks(List<Books> authorBooks) {
        this.authorBooks = authorBooks;
    }

/*authors

    authorid - long primary key
    lastname - String last name of the author
    firstname - String first name of the author*/
}
