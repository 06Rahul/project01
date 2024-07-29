package com.Rahul.firstjobapp.job.impl;

import com.Rahul.firstjobapp.job.Job;
import com.Rahul.firstjobapp.job.JobRepository;
import com.Rahul.firstjobapp.job.Jobservice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobserviceImpl implements Jobservice {

    JobRepository jobRepository;
   // private Long nextId = 1L;

    public JobserviceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    //private List<Job> jobs = new ArrayList<>();

    @Override
    public List<Job> finsAll() {
        return jobRepository.findAll();
    }


    @Override
    public void createjob(Job job) {
       // job.setId(nextId++);
        jobRepository.save(job);

    }

    @Override
    public Job getJobbyid(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deletejobbyid(Long id) {
        try{
       jobRepository.deleteById(id);
       return true;}
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updatejob(Long id, Job updatedjob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
            if (jobOptional.isPresent()){
                Job job = jobOptional.get();
                job.setTitle(updatedjob.getTitle());
                job.setDescription(updatedjob.getDescription());
                job.setMinSalary(updatedjob.getMinSalary());
                job.setMaxSalary(updatedjob.getMaxSalary());
                job.setLocation(updatedjob.getLocation());
                jobRepository.save(job);
                return  true;
            }
        return false;
        }


    }

