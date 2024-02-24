package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {
    @NotNull(message = "Location is required")
    @Size(min = 3, max = 100, message = "Location must be between 3 and 100 characters")
    private String location;

    @OneToMany
    @JoinColumn(name="employer_id")
    private List<Job> jobs = new ArrayList<>();

    public Employer() {

    }

    public Employer(String aLocation) {
        super();
        this.location = aLocation;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location; }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
