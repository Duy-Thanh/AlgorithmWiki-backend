package com.algorithmswiki.apps.backend.backend.Entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String permission;

    @OneToMany(mappedBy = "userAccount")
    private Set<Algorithms> algorithms;

    public UserAccount() { }

    public UserAccount(String username, String password, String fullName, String email, String permission) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.permission = permission;
    }
    
    // Getter and Setters
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPermission() {
        return permission;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Set<Algorithms> getAlgorithms() {
        return algorithms;
    }

    public void setAlgorithms(Set<Algorithms> algorithms) {
        this.algorithms = algorithms;
    }
}
