package com.Rahul.firstjobapp.job;

import java.util.List;

public interface Jobservice {
    List<Job> finsAll();
    void createjob(Job job);

    Job getJobbyid(Long id);

    boolean deletejobbyid(Long id);

    boolean updatejob(Long id, Job updatedjob);
}
