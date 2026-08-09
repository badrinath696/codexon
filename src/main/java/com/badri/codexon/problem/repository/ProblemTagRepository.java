package com.badri.codexon.problem.repository;

import com.badri.codexon.problem.entity.ProblemTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemTagRepository extends JpaRepository<ProblemTag, Long> {
}
