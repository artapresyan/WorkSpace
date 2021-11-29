package com.workspace.workSpace.conroller;

import com.workspace.workSpace.entity.Job;
import com.workspace.workSpace.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/job")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping("/all")
    public List<Job> getAllJobs() {
        return jobService.getJobs();
    }

    @PostMapping("/add")
    public String addJob(@RequestParam String jobTitle,@RequestParam String jobType,@RequestParam String jobLocation,
                         @RequestParam String jobCategory,@RequestParam String jobDescription,
                         @RequestParam String jobResponsibilities,@RequestParam String jobQualifications,
                         @RequestParam String jobContacts){
        return jobService.addJob(jobTitle, jobType, jobLocation, jobCategory, jobDescription,
                jobResponsibilities, jobQualifications, jobContacts);
    }

    @PutMapping("/edit")
    public String editJob(@RequestParam(required = false) String jobTitle,@RequestParam(required = false) String jobType,
                          @RequestParam(required = false) String jobLocation, @RequestParam(required = false) String jobCategory,
                          @RequestParam(required = false) String jobDescription, @RequestParam(required = false) String jobResponsibilities,
                          @RequestParam(required = false) String jobQualifications, @RequestParam(required = false) String jobContacts,
                          @RequestParam Long jobId){
        return jobService.editJob(jobId, jobTitle, jobType, jobLocation, jobCategory, jobDescription,
                jobResponsibilities, jobQualifications, jobContacts);
    }

    @DeleteMapping("/remove")
    public String removeJob(@RequestParam Long jobId) {
        return jobService.removeJob(jobId);
    }
}
