package com.selimsahin.jobseekr.job.Impl;

import com.selimsahin.jobseekr.job.Job;
import com.selimsahin.jobseekr.job.JobRepository;
import com.selimsahin.jobseekr.job.JobService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    private JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job createJob(@RequestBody Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job findById(int id) {
        return jobRepository.findById((long) id).orElse(null);
    }

    @Override
    public boolean updateJob(int id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById((long) id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteJobById(int id) {
        try {
            jobRepository.deleteById((long) id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
