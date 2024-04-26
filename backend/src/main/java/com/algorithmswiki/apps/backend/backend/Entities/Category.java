package com.algorithmswiki.apps.backend.backend.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    private String categoryDescription;

    @ManyToOne
    @JoinColumn(name = "algorithm_id")
    private Algorithms algorithms;

    public Category() { }

    public Category(String categoryName, String categoryDescription, Algorithms algorithms) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.algorithms = algorithms;
    }

    public Long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
