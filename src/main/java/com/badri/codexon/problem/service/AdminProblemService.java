package com.badri.codexon.problem.service;

import com.badri.codexon.common.enums.ProblemStatus;
import com.badri.codexon.common.exception.ProblemNotFoundException;
import com.badri.codexon.problem.dto.requestDto.ProblemPatchRequest;
import com.badri.codexon.problem.dto.requestDto.ProblemRequest;
import com.badri.codexon.problem.dto.responseDto.ProblemResponse;
import com.badri.codexon.problem.entity.Problem;
import com.badri.codexon.problem.mapper.ProblemMapper;
import com.badri.codexon.problem.repository.AdminProblemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminProblemService {

    private final AdminProblemRepository adminProblemRepository;
    private final ProblemMapper problemMapper;

    @Transactional
    public ProblemResponse createProblem(ProblemRequest request){
        Problem problem=problemMapper.toProblem(request);
        problem.setProblemStatus(ProblemStatus.DRAFT);
        return problemMapper.toProblemResponse(adminProblemRepository.save(problem));
    }

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

    public void editProblem(Long problemId, ProblemPatchRequest problemPatchRequest){
        Problem problem=adminProblemRepository.findById(problemId).orElseThrow(()->new ProblemNotFoundException(problemId));
        problemMapper.editProblem(problem,problemPatchRequest);
    }

}
