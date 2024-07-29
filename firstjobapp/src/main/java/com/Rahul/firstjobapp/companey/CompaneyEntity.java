package com.Rahul.firstjobapp.companey;


import Review.Review;
import com.Rahul.firstjobapp.job.Job;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;



@Entity
public class CompaneyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

   // @JsonIgnore
    //@OneToMany(mappedBy = "companyEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<Review> reviews;

    @JsonIgnore
    @OneToMany(mappedBy = "companyEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Job> jobs;

    public CompaneyEntity() {}

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   /* public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }*/

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}

