package com.badri.codexon.problem.service;

import com.badri.codexon.common.enums.ProblemStatus;
import com.badri.codexon.common.exception.DuplicateProblemException;
import com.badri.codexon.common.exception.ProblemNotFoundException;
import com.badri.codexon.problem.dto.requestDto.ProblemPatchRequest;
import com.badri.codexon.problem.dto.requestDto.ProblemRequest;
import com.badri.codexon.problem.dto.responseDto.ProblemResponse;
import com.badri.codexon.problem.entity.Problem;
import com.badri.codexon.problem.mapper.ProblemMapper;
import com.badri.codexon.problem.repository.AdminProblemRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminProblemService {

    private final AdminProblemRepository adminProblemRepository;
    private final ProblemMapper problemMapper;

    @Transactional
    public ProblemResponse createProblem(ProblemRequest request){
        if(adminProblemRepository.existsByTitle(request.title())){
            throw new DuplicateProblemException(request.title());
        }
        Problem problem=problemMapper.toProblem(request);
        problem.setProblemStatus(ProblemStatus.DRAFT);
        return problemMapper.toProblemResponse(adminProblemRepository.save(problem));
    }

    @Transactional
    public ProblemResponse updateProblem(Long problemId,ProblemRequest problemRequest){
        Problem problem=adminProblemRepository.findById(problemId).orElseThrow(()->new ProblemNotFoundException(problemId));
        problem.setProblemStatus(ProblemStatus.DRAFT);
        problem.setConstraints(problemRequest.constraints());
        problem.setTitle(problemRequest.title());
        problem.setDifficulty(problemRequest.difficulty());
        problem.setDescription(problemRequest.description());
        problem.setTimeLimitMs(problemRequest.timeLimitMs());
        problem.setMemoryLimitMb(problemRequest.memoryLimitMb());
        return problemMapper.toProblemResponse(problem);
    }

   @Transactional
    public void editProblem(Long problemId, ProblemPatchRequest problemPatchRequest){
        Problem problem=adminProblemRepository.findById(problemId).orElseThrow(()->new ProblemNotFoundException(problemId));
        problemMapper.editProblem(problem,problemPatchRequest);
    }

}
