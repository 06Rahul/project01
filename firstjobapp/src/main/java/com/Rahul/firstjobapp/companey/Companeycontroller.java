package com.Rahul.firstjobapp.companey;

import com.Rahul.firstjobapp.job.Job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class Companeycontroller {

    private final CompaneyService companeyService;

    public Companeycontroller(CompaneyService companeyService) {
        this.companeyService = companeyService;
    }

    @GetMapping
    public ResponseEntity<List<CompaneyEntity>> getAllcompanies() {
        return new ResponseEntity<>(companeyService.getAllCompanies(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompaney(@PathVariable Long id, @RequestBody CompaneyEntity companeyEntity) {
        boolean isUpdated = companeyService.updateCompaney(id, companeyEntity);
        if (isUpdated) {
            return new ResponseEntity<>("Companey updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Companey not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<String> addCompaney(@RequestBody CompaneyEntity companeyEntity) {
        companeyService.createcompaney(companeyEntity);
        return new ResponseEntity<>("Companey added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletecompaney(@PathVariable Long id) {
        boolean isDeleted = companeyService.delletecompaneyByid(id);
        if (isDeleted) {
            return new ResponseEntity<>("Companey successfully deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Companey not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompaneyEntity> getCompaneyById(@PathVariable Long id) {
        CompaneyEntity companeyEntity = companeyService.getcompaneybyid(id);
        if (companeyEntity != null) {
            return new ResponseEntity<>(companeyEntity, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
