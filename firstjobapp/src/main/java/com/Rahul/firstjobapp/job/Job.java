package com.Rahul.firstjobapp.job;

import com.Rahul.firstjobapp.companey.CompaneyEntity;
import jakarta.persistence.*;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;           // Ensure this matches "title" in JSON
    private String description;     // Ensure this matches "description" in JSON
    private Double minSalary;       // Ensure this matches "minSalary" in JSON
    private Double maxSalary;       // Ensure this matches "maxSalary" in JSON
    private String location;        // Ensure this matches "location" in JSON

    public Job(Long id, String title, String description, Double minSalary, Double maxSalary, String location, CompaneyEntity companyEntity) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
        this.companyEntity = companyEntity;
    }

    @ManyToOne
    @JoinColumn(name = "company_id") // Corrected spelling
    private CompaneyEntity companyEntity;

    public CompaneyEntity getCompanyEntity() {
        return companyEntity;
    }

    public void setCompanyEntity(CompaneyEntity companyEntity) {
        this.companyEntity = companyEntity;
    }



    // Default constructor
    public Job() {}

    // All-args constructor


    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Double minSalary) {
        this.minSalary = minSalary;
    }

    public Double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
