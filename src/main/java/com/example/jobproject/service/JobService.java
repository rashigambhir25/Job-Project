package com.example.jobproject.service;

import com.example.jobproject.model.JobPost;
import com.example.jobproject.repo.JobRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobService {

    private JobRepo repo;

    public JobService(JobRepo repo) {
        this.repo = repo;
    }

    public void addJobs(JobPost jobPost) {
        repo.addJob(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return repo.getAllJobs();
    }
}
