package com.Rahul.firstjobapp.companey.impl;

import com.Rahul.firstjobapp.companey.CompaneyEntity;
import com.Rahul.firstjobapp.companey.CompaneyReps;
import com.Rahul.firstjobapp.companey.CompaneyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CompaneyServiceimpl implements CompaneyService {

    private final CompaneyReps companeyReps;

    public CompaneyServiceimpl(CompaneyReps companeyReps) {
        this.companeyReps = companeyReps;
    }

    @Override
    public List<CompaneyEntity> getAllCompanies() {
        return companeyReps.findAll();
    }

    @Override
    @Transactional
    public boolean updateCompaney(Long id, CompaneyEntity companeyEntity) {
        Optional<CompaneyEntity> companeyoptional = companeyReps.findById(id);
        if (companeyoptional.isPresent()) {
            CompaneyEntity companey = companeyoptional.get();
            companey.setDescription(companeyEntity.getDescription());
            companey.setName(companeyEntity.getName());
            companey.setJobs(companeyEntity.getJobs());
            companeyReps.save(companey);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public void createcompaney(CompaneyEntity companeyEntity) {
        companeyReps.save(companeyEntity);
    }

    @Override
    @Transactional
    public boolean delletecompaneyByid(Long id) {
        if (companeyReps.existsById(id)) {
            companeyReps.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public CompaneyEntity getcompaneybyid(Long id) {
        return companeyReps.findById(id).orElse(null);
    }
}
