package com.badri.codexon.problem.repository;

import com.badri.codexon.problem.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProblemRepository extends JpaRepository<Problem , Long>, JpaSpecificationExecutor<Problem> {

}
