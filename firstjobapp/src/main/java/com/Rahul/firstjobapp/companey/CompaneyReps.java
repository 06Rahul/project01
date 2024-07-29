package com.Rahul.firstjobapp.companey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompaneyReps extends JpaRepository<CompaneyEntity, Long> {
}
