package com.algorithmswiki.apps.backend.backend.Entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contentsRate;
    private LocalDateTime dateAdded;

    @ManyToOne
    @JoinColumn(name = "algorithm_id")
    private Algorithms algorithm;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;

    public Rate() { }

    public Rate(String contentsRate, LocalDateTime dateAdded, Algorithms algorithms, UserAccount userAccount) {
        this.contentsRate = contentsRate;
        this.dateAdded = dateAdded;
        this.algorithm = algorithms;
        this.userAccount = userAccount;
    }

    public Long getId() {
        return id;
    }

    public String getContentsRate() {
        return contentsRate;
    }

    public String getDateAdded() {
        return dateAdded.toString();
    }

    // Setters
    public void setContentsRate(String contentsRate) {
        this.contentsRate = contentsRate;
    }

    public void setDateAdded(String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.dateAdded = LocalDateTime.parse(dateTimeString, formatter);
    }

    public Algorithms getAlgorithms() {
        return algorithm;
    }

    public void setAlgorithms(Algorithms algorithms) {
        this.algorithm = algorithms;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}