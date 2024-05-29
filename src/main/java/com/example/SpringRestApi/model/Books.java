package com.example.SpringRestApi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String author;
    private int year;
    private boolean isPublished;

    public Books(){}

    public Books(long id, String name, String author, int year, boolean isPublished) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        this.isPublished = isPublished;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }
}
