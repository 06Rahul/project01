package com.Rahul.firstjobapp.companey;

import java.util.List;

public interface CompaneyService {
    List<CompaneyEntity> getAllCompanies();
    boolean updateCompaney(Long id, CompaneyEntity companeyEntity);
    void createcompaney(CompaneyEntity companeyEntity);
    boolean delletecompaneyByid(Long id);
    CompaneyEntity getcompaneybyid(Long id);
}
