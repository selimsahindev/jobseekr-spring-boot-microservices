package com.selimsahin.jobseekr.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    Job findById(int id);
    Job createJob(Job job);
    boolean updateJob(int id, Job job);
    boolean deleteJobById(int id);
}
