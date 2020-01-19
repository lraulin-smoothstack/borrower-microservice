package com.smoothstack.december.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;

    @Column(name = "authorName")
    private String authorName;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "tbl_book_authors", joinColumns = { @JoinColumn(name = "authorId") }, inverseJoinColumns = {
            @JoinColumn(name = "bookId") })
    private Set<Book> books = new HashSet<>();

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return authorName;
    }

    public void setName(String name) {
        this.authorName = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

}