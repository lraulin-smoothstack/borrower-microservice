package com.smoothstack.december.entity;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_book")
public class Book {

    private String title;
    private Integer id;
    private List<Author> authors;
    private List<Genre> genres;
    private List<Branch> branches;
    private Publisher publisher;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorNames() {
        return String.join(", ", getAuthors().stream().map(a -> a.getName()).collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        return new StringBuilder().append("{").append(this.id).append("} \"").append(title).append("\" by ")
                .append(getAuthorNames()).toString();
    }
}
