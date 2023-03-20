package com.geunbok.onlinevotingsys.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    @Query("SELECT p FROM Candidate p ORDER BY p.id DESC")
    List<Candidate> findAllDesc();
}
