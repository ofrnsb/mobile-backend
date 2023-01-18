package com.lsb1.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsb1.Models.Jobs;
import com.lsb1.Repos.jobsRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class JobsService {

  @Autowired
  private jobsRepo jobsRepo;

  public Jobs saveJobs(Jobs jobs) {
    return jobsRepo.save(jobs);
  }

  public Jobs findById(Long id) {
    Optional<Jobs> jobs = jobsRepo.findById(id);
    if (!jobs.isPresent()) {
      return null;
    }
    return jobs.get();
  }

  public Iterable<Jobs> findAll() {
    return jobsRepo.findAll();
  }

  public void remove(Long id) {
    jobsRepo.deleteById(id);
  }
}
