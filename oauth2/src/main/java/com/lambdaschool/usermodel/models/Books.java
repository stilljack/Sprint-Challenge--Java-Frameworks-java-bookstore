package com.lambdaschool.usermodel.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.usermodel.logging.Loggable;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Loggable
@Entity
@Table(name = "books")
public class Books  extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    @Column(nullable = false)
    private String booktitle;

    @Column(nullable = false,
            unique = true)
    private String isbn;

    private int copy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sectionid",
            nullable = false)
    @JsonIgnoreProperties({"books", "hibernateLazyInitializer"})
    private Section section;

    @ManyToMany
    @JoinTable(name = "bookauthor",
            joinColumns = @JoinColumn(name = "bookid"),
            inverseJoinColumns = @JoinColumn(name = "authorid"))
    @JsonIgnoreProperties("books")
    List<Authors> authors = new ArrayList<>();
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

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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
}
