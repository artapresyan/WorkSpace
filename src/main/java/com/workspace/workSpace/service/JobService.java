package com.workspace.workSpace.service;

import com.workspace.workSpace.entity.Job;
import com.workspace.workSpace.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class JobService {
    @Autowired
    JobRepository jobRepository;

    public List<Job> getJobs(){
        return jobRepository.findAll();
    }

    public String removeJob(Long jobId){
        try {
            jobRepository.deleteById(jobId);
            return jobRepository.getById(jobId).getJobTitle()+" job removed.";
        }catch (NoSuchElementException e){
            return "ERROR 404";
        }
    }

    public String addJob(String jobTitle, String jobType, String jobLocation, String jobCategory,
                         String jobDescription, String jobResponsibilities, String jobQualifications,
                         String jobContacts){
        if (jobTitle.matches("[\\w\\s-+:!@#$%&*={};.,`()/'<>\\[\\]]{15,50}") && jobType.matches("[a-zA-z-]{4,}")
                && jobLocation.matches("[\\w\\s,/&&[^_]]{5,}") && jobCategory.matches("[a-zA-z\\s]{2,}")
                && jobDescription.matches("[\\w\\s-+:!@#$%&*={};.,`()/'<>\\[\\]]{30,}")
                && jobResponsibilities.matches("[\\w\\s-+:!@#$%&*={};.,`()/'<>\\[\\]]{20,}")
                && jobQualifications.matches("[\\w\\s-+:!@#$%&*={};.,`()/'<>\\[\\]]{10,}")
                && jobContacts.matches("(374([99]|[98]|[97]|[96]|[95]|[94]|[93]|[91]|[77]|[60]|[55]|[44]|[43]|" +
                "[41]|[33]|[12]|[11]|[10]){2}[0-9]{6}) | (^[a-z][a-z0-9-_.]+[a-z0-9]+@[a-z]+\\.[a-z.]{2,})")) {
            Job newJob = new Job(jobTitle, jobType, jobLocation, jobCategory, jobDescription,
                    jobResponsibilities, jobQualifications, jobContacts);
            jobRepository.save(newJob);
            return "Congratulations! " + jobTitle + "'s advertisement added";
        }else
            return "ERROR 404";
    }

    public String editJob(Long jobId, String jobTitle, String jobType, String jobLocation, String jobCategory,
                          String jobDescription, String jobResponsibilities, String jobQualifications,
                          String jobContacts){
        try{
            Job job=jobRepository.getById(jobId);
            if (jobTitle.matches("[\\w\\s-+:!@#$%&*={};.,`()/'<>\\[\\]]{15,50}"))
                job.setJobTitle(jobTitle);
            if (jobType.matches("[a-zA-z-]{4,}"))
                job.setJobType(jobType);
            if (jobLocation.matches("[\\w\\s,/&&[^_]]{5,}"))
                job.setJobLocation(jobLocation);
            if (jobCategory.matches("[a-zA-z\\s]{2,}"))
                job.setJobCategory(jobCategory);
            if (jobDescription.matches("[\\w\\s-+:!@#$%&*={};.,`()/'<>\\[\\]]{30,}"))
                job.setJobDescription(jobDescription);
            if (jobResponsibilities.matches("[\\w\\s-+:!@#$%&*={};.,`()/'<>\\[\\]]{20,}"))
                job.setJobResponsibilities(jobResponsibilities);
            if (jobQualifications.matches("[\\w\\s-+:!@#$%&*={};.,`()/'<>\\[\\]]{10,}"))
                job.setJobQualifications(jobQualifications);
            if (jobContacts.matches("(374([99]|[98]|[97]|[96]|[95]|[94]|[93]|[91]|[77]|[60]|[55]|[44]|[43]|" +
                    "[41]|[33]|[12]|[11]|[10]){2}[0-9]{6}) | (^[a-z][a-z0-9-_.]+[a-z0-9]+@[a-z]+\\.[a-z.]{2,})"))
                job.setJobContacts(jobContacts);
            jobRepository.save(job);
            return "Information successfully updated";
        }catch (NoSuchElementException e){
            return "ERROR 404";
        }
    }
}
