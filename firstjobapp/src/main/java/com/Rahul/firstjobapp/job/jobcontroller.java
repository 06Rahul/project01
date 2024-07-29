package com.Rahul.firstjobapp.job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
//@RequestMapping("/jobs")
public class jobcontroller {

    public jobcontroller(Jobservice jobservice) {
        this.jobservice = jobservice;
    }

    private  Jobservice jobservice;


    @GetMapping("/jobs")
    public ResponseEntity<List<Job> >findall(){
       return ResponseEntity.ok(jobservice.finsAll());
    }

    @PostMapping ("/jobs")
    public ResponseEntity<String > createjob(@RequestBody Job job){
        jobservice.createjob(job);
        //CompaneyEntity c =job.getCompaneyEntity();
        return new ResponseEntity<>("Job added Succesfully !",HttpStatus.CREATED);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getjobbyid(@PathVariable Long id){
        Job job = jobservice.getJobbyid(id);
        if (job != null)
        return  new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

   /* @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable Long id) {
        return jobs.stream().filter(job -> job.getId().equals(id)).findFirst().orElse(null);
    }*/
    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String >deletejob(@PathVariable Long id){
        boolean deleted = jobservice.deletejobbyid(id);
        if (deleted)return new ResponseEntity<>("Job deleted succesfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<String > updatejob(@PathVariable Long id, @RequestBody Job Updatedjob){
        boolean updated = jobservice.updatejob(id,Updatedjob);
        if (updated) return new ResponseEntity<>("Job updated successfully",HttpStatus.OK);

        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
