package com.selimsahin.jobseekr.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    String createJob(Job job);
    Job findById(int id);

    boolean deleteJobById(int id);
    boolean updateJob(int id, Job job);
}
