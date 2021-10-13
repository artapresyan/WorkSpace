package com.workspace.workSpace.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long jobId;

    @Column(name = "title", nullable = false)
    private String jobTitle;

    @Column(name = "type", nullable = false)//full-time, half-time, etc.
    private String jobType;

    @Column(name = "location", nullable = false)
    private String jobLocation;

    @Column(name = "category", nullable = false)
    private String jobCategory;

    @Column(name = "description", nullable = false)
    private String jobDescription;

    @Column(name = "responsibilities", nullable = false)
    private String jobResponsibilities;

    @Column(name = "qualifications", nullable = false)
    private String jobQualifications;

    @Column(name = "contact_us", nullable = false)
    private String jobContacts;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "company_id")
    private Company company;

    public Job() {
    }

    public Job(String jobTitle, String jobType, String jobLocation, String jobCategory,
               String jobDescription, String jobResponsibilities, String jobQualifications,
               String jobContacts) {
        this.jobTitle = jobTitle;
        this.jobType = jobType;
        this.jobLocation = jobLocation;
        this.jobCategory = jobCategory;
        this.jobDescription = jobDescription;
        this.jobResponsibilities = jobResponsibilities;
        this.jobQualifications = jobQualifications;
        this.jobContacts = jobContacts;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobResponsibilities() {
        return jobResponsibilities;
    }

    public void setJobResponsibilities(String jobResponsibilities) {
        this.jobResponsibilities = jobResponsibilities;
    }

    public String getJobQualifications() {
        return jobQualifications;
    }

    public void setJobQualifications(String jobQualifications) {
        this.jobQualifications = jobQualifications;
    }

    public String getJobContacts() {
        return jobContacts;
    }

    public void setJobContacts(String jobContacts) {
        this.jobContacts = jobContacts;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
