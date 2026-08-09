package com.badri.codexon.problem.controller;

import com.badri.codexon.common.dto.PageResponse;
import com.badri.codexon.common.enums.Difficulty;
import com.badri.codexon.problem.dto.responseDto.ProblemDetailsResponse;
import com.badri.codexon.problem.dto.responseDto.ProblemListResponse;
import com.badri.codexon.problem.service.ProblemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/problems")
public class ProblemController {

    private final ProblemService problemService;

    public ProblemController(ProblemService problemService){
        this.problemService=problemService;
    }

    @GetMapping
    private ResponseEntity<PageResponse<ProblemListResponse>> getProblems(
            @RequestParam(required = false) @Valid Difficulty difficulty,
            @RequestParam(required = false) @Valid String searchKey,
            @RequestParam(required = false) @Valid String tag,
            @RequestParam(required = false) @Valid boolean premium,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "createdAt") String sort,
            @RequestParam(defaultValue = "desc") String direction
            ){
        return ResponseEntity.ok(problemService.getProblems(difficulty,searchKey,tag,premium,page,size,sort,direction));
    }

    @GetMapping("/{problemId}")
    private ResponseEntity<ProblemDetailsResponse> getProblem(@PathVariable Long problemId){
        return ResponseEntity.ok(problemService.getProblem(problemId));
    }
}
