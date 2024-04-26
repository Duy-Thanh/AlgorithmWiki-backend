package com.algorithmswiki.apps.backend.backend.Entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;

@Entity
public class Algorithms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contents;
    private LocalDateTime dateAdded;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;

    @OneToMany(mappedBy = "algorithms")
    private Set<Category> categories;

    public Algorithms() { }

    public Algorithms(String contents, LocalDateTime dateAdded, UserAccount account) {
        this.contents = contents;
        this.dateAdded = dateAdded;
        this.userAccount = account;
    }

    // Getters and Setters
    public String getAlgorithmsContents() {
        return contents;
    }

    public String getAlgorithmsDateTimeAdded() {
        return dateAdded.toString();
    }

    public UserAccount getAlgorithmsUserAccount() {
        return userAccount;
    }

    public void setAlgorithmsContents(String contents) {
        this.contents = contents;
    }

    public void setAlgoirthmsUserAccount(UserAccount account) {
        this.userAccount = account;
    }

    public void setAlgorithmsDateTimeAdded(String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.dateAdded = LocalDateTime.parse(dateTimeString, formatter);        
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}

