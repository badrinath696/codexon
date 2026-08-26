package com.badri.codexon.problem.service;

import com.badri.codexon.common.dto.PageResponse;
import com.badri.codexon.common.enums.Difficulty;
import com.badri.codexon.common.enums.ProblemStatus;
import com.badri.codexon.common.exception.InvalidSortFieldException;
import com.badri.codexon.common.exception.ProblemNotFoundException;
import com.badri.codexon.example.repository.ExampleRepository;
import com.badri.codexon.problem.dto.responseDto.ProblemDetailsResponse;
import com.badri.codexon.problem.dto.responseDto.ProblemListResponse;
import com.badri.codexon.problem.entity.Problem;
import com.badri.codexon.problem.mapper.ProblemMapper;
import com.badri.codexon.problem.repository.ProblemRepository;
import com.badri.codexon.problem.specification.ProblemSpecification;
import com.badri.codexon.testcase.repository.TestCaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class ProblemService {

    private final ProblemRepository problemRepository;
    private final ProblemMapper problemMapper;
    private final TestCaseRepository testCaseRepository;
    private final ExampleRepository exampleRepository;


    public ProblemService(ProblemRepository problemRepository, ProblemMapper problemMapper, TestCaseRepository testCaseRepository,ExampleRepository exampleRepository){
        this.problemRepository=problemRepository;
        this.problemMapper=problemMapper;
        this.testCaseRepository=testCaseRepository;
        this.exampleRepository=exampleRepository;
    }

    @Transactional(readOnly = true)
    public ProblemDetailsResponse getProblem(Long problemId){
        Problem problem=problemRepository.findById(problemId).orElseThrow(()->new ProblemNotFoundException(problemId));
        return problemMapper.toDetailsResponseForUser(problem,exampleRepository.getExamplesById(problemId),testCaseRepository.getTestCasesForUser(problemId));
    }

    public static final Set<String> sortBYOnly=Set.of(
            "createdAt","title","difficulty"
    );

    @Transactional
    public PageResponse<ProblemListResponse> getProblems(
            Difficulty difficulty,
            String searchKey,
            String tag,
            boolean premium,
            int page,
            int size,
            String sort,
            String direction
    ){
        Specification<Problem> spec= ProblemSpecification.isPublic(ProblemStatus.PUBLISHED);
        if(difficulty!=null){
            spec=spec.and(ProblemSpecification.hasDifficulty(difficulty));
        }
        if(searchKey!=null && !searchKey.isBlank()){
            searchKey=searchKey.trim();
            spec=spec.and(ProblemSpecification.search(searchKey));
        }
        if(tag!=null && !tag.isBlank()){
            spec=spec.and(ProblemSpecification.hasTag(tag));
        }
        if(premium){
            spec=spec.and(ProblemSpecification.isPremium(true));
        }

        Sort.Direction sortDirection=Sort.Direction.fromString(direction);

        if(!sortBYOnly.contains(sort)){
            throw new InvalidSortFieldException(sort);
        }
        Sort sortObject=Sort.by(sortDirection,sort);

        Pageable pageable= PageRequest.of(page,size,sortObject);
        Page<Problem> problemPage=problemRepository.findAll(spec,pageable);

        Page<ProblemListResponse> response=problemPage.map(problemMapper::toListResponse);

        return PageResponse.toPageResponse(response);
    }
}
