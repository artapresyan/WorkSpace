package com.workspace.workSpace.service;

import com.workspace.workSpace.entity.Job;
import com.workspace.workSpace.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class JobsService {
    @Autowired
    JobRepository jobRepository;

    public List<Job> getJobs(){
        return jobRepository.findAll();
    }

    public String removeJob(Long id){
        try {
            jobRepository.deleteById(id);
            return jobRepository.getById(id).getJobTitle()+" job removed.";
        }catch (NoSuchElementException e){
            return "ERROR 404";
        }
    }

    public String addJob(String jobTitle, String jobType, String jobLocation, String jobCategory,
                         String jobDescription, String jobResponsibilities, String jobQualifications,
                         String jobContacts){
        Job newJob = new Job(jobTitle, jobType, jobLocation, jobCategory, jobDescription,
                                jobResponsibilities, jobQualifications, jobContacts);
        jobRepository.save(newJob);
        return "Congratulations! "+jobTitle+"'s advertisement added";
    }

    public String editJob(Long id, String jobTitle, String jobType, String jobLocation, String jobCategory,
                          String jobDescription, String jobResponsibilities, String jobQualifications,
                          String jobContacts){
        try{
            Job job=jobRepository.getById(id);
            if (jobTitle !=null)
                job.setJobTitle(jobTitle);
            if (jobType !=null)
                job.setJobType(jobType);
            if (jobLocation !=null)
                job.setJobLocation(jobLocation);
            if (jobCategory !=null)
                job.setJobCategory(jobCategory);
            if (jobDescription !=null)
                job.setJobDescription(jobDescription);
            if (jobResponsibilities !=null)
                job.setJobResponsibilities(jobResponsibilities);
            if (jobQualifications !=null)
                job.setJobQualifications(jobQualifications);
            if (jobContacts !=null)
                job.setJobContacts(jobContacts);
            jobRepository.save(job);
            return "Information successfully updated";
        }catch (NoSuchElementException e){
            return "ERROR 404";
        }
    }
}
