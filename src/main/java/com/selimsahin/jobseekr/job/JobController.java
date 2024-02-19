package com.selimsahin.jobseekr.job;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        return ResponseEntity.ok(jobService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable int id) {
        Job job = jobService.findById(id);
        if (job != null) {
            return ResponseEntity.ok(job);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jobService.createJob(job));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable int id, @RequestBody Job job) {
        boolean isUpdated = jobService.updateJob(id, job);
        if (isUpdated) {
            return ResponseEntity.ok("Job updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable int id) {
        boolean isDeleted = jobService.deleteJobById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Job deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
