package com.example.jobproject.controller;

import com.example.jobproject.model.JobPost;
import com.example.jobproject.service.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JobController {

    private JobService service;

    public JobController(JobService service) {
        this.service = service;
    }

    @GetMapping({"/", "home"})
    public String home() {
        return "home";
    }

    @GetMapping({"addjob"})
    public String addJob() {
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost) {
        service.addJobs(jobPost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewJobs(Model model) {
        List<JobPost> jobs = service.getAllJobs();
        model.addAttribute("jobPosts", jobs);
        return "viewalljobs";
    }
}
