package com.badri.codexon.testcase.repository;

import com.badri.codexon.testcase.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long> {

    @Query("select t from TestCase t where t.problem.id=:problemId and t.hidden=false ")
    List<TestCase> getTestCasesForUser(Long problemId);
}
