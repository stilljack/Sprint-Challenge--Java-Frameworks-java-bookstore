package com.lambdaschool.usermodel.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.usermodel.logging.Loggable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Loggable
@Entity
@Table(name = "book")
public class Books  extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false,
            unique = true)
    private String ISBN;

    private int copy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sectionid",
            nullable = false)
    @JsonIgnoreProperties("books")
    private Section section;

    @ManyToMany
    @JoinTable(name = "wrote",
            joinColumns = @JoinColumn(name = "bookid"),
            inverseJoinColumns = @JoinColumn(name = "authorid"))
    @JsonIgnoreProperties("authorBooks")
    private List<Authors> authors = new ArrayList<>();
   /* bookid - long primary key
    booktitle - String the title of the book. Cannot be null.
    ISBN - String the ISBN number of the book. Cannot be null. Must be unique
    copy - Int the year the book was published (copyright date)*/


    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }

    public List<Authors> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Authors> authors) {
        this.authors = authors;
    }

    public Books() {
    }

}
