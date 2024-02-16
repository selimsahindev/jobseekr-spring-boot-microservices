package com.selimsahin.jobseekr.job.Impl;

import com.selimsahin.jobseekr.job.Job;
import com.selimsahin.jobseekr.job.JobService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public String createJob(@RequestBody Job job) {
        job.setId(nextId++);
        jobs.add(job);
        return "Job created successfully!";
    }

    @Override
    public Job findById(int id) {
        for (Job job : jobs) {
            if (job.getId() == id) {
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteJobById(int id) {
        for (Job job : jobs) {
            if (job.getId() == id) {
                jobs.remove(job);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJob(int id, Job updatedJob) {
        for (Job job : jobs) {
            if (job.getId() == id) {
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                return true;
            }
        }
        return false;
    }
}
