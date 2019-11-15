package com.lambdaschool.usermodel.models;

import com.lambdaschool.usermodel.logging.Loggable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Loggable
@Entity
@Table(name = "author")
public class Authors extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    private String lname;

    private String fname;

@ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    List<Books> authorBooks=new ArrayList<>();

    public long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(long authorid) {
        this.authorid = authorid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFirstname() {
        return fname;
    }

    public void setFirstname(String firstname) {
        this.fname = firstname;
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
/*

    public Authors(String firstname, List<Books> authorBooks) {
        this.fname = firstname;
        this.authorBooks = authorBooks;
    }
*/

    public Authors() {
    }
}
