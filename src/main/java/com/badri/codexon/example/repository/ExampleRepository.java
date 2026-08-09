package com.badri.codexon.example.repository;

import com.badri.codexon.example.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExampleRepository extends JpaRepository<Example, Long> {

    @Query("select e from Example e where e.problem.id=:problemId")
    List<Example> getExamplesById(Long problemId);
}
