package com.badri.codexon.problem.repository;

import com.badri.codexon.problem.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminProblemRepository extends JpaRepository<Problem,Long> {

    boolean existsByTitle(String title);


}
