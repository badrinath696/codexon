package com.badri.codexon.problem.service;

import com.badri.codexon.common.exception.ProblemNotFoundException;
import com.badri.codexon.editorial.dto.EditorialPatchRequest;
import com.badri.codexon.editorial.dto.EditorialRequest;
import com.badri.codexon.editorial.dto.EditorialResponse;
import com.badri.codexon.editorial.service.EditorialService;
import com.badri.codexon.example.dto.ExamplePatchRequest;
import com.badri.codexon.example.dto.ExampleRequest;
import com.badri.codexon.example.dto.ExampleResponse;
import com.badri.codexon.example.service.ExampleService;
import com.badri.codexon.problem.dto.requestDto.FullProblemRequest;
import com.badri.codexon.problem.dto.requestDto.ProblemTagRequest;
import com.badri.codexon.problem.dto.responseDto.ProblemDetailsResponse;
import com.badri.codexon.problem.dto.responseDto.ProblemResponse;
import com.badri.codexon.problem.dto.responseDto.ProblemTagResponse;
import com.badri.codexon.problem.entity.Problem;
import com.badri.codexon.problem.mapper.ProblemMapper;
import com.badri.codexon.problem.repository.ProblemRepository;
import com.badri.codexon.testcase.dto.TestCasePatchRequest;
import com.badri.codexon.testcase.dto.TestCaseRequest;
import com.badri.codexon.testcase.dto.TestCaseResponse;
import com.badri.codexon.testcase.service.TestCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminProblemOrchestra {

    private final AdminProblemService adminProblemService;
    private final ExampleService exampleService;
    private final TestCaseService testCaseService;
    private final EditorialService editorialService;
    private final ProblemMapper problemMapper;
    private final ProblemTagService problemTagService;
    private final ProblemRepository problemRepository;

    public List<ExampleResponse> createExamples(Long problemId, List<ExampleRequest> requests) {
        Problem problem=problemRepository.findById(problemId).orElseThrow(()->new ProblemNotFoundException(problemId));
        return requests.stream().map(request->exampleService.createExample(problem,request)).toList();
    }

    public List<TestCaseResponse> createTestCases(Long problemId, List<TestCaseRequest> testCaseRequests){
        Problem problem=problemRepository.findById(problemId).orElseThrow(()->new ProblemNotFoundException(problemId));
        return testCaseRequests.stream().map(testCaseRequest -> testCaseService.createTestCase(problem,testCaseRequest)).toList();
    }

    public EditorialResponse createEditorial(Long problemId, EditorialRequest editorialRequest){
        return editorialService.createEditorial(problemId,editorialRequest);
    }

    public List<ProblemTagResponse> createProblemTags(Long problemId, List<ProblemTagRequest> tagIds){
        Problem problem=problemRepository.findById(problemId).orElseThrow(()->new ProblemNotFoundException(problemId));
        return tagIds.stream().map(tagId->problemTagService
                .createProblemTag(problem, tagId.tagId())).toList();
    }

    public List<ExampleResponse> updateExamples(Long problemId,List<ExampleRequest> exampleRequests){
        problemRepository.findById(problemId).orElseThrow(()->new ProblemNotFoundException(problemId));
        return exampleRequests.stream().map(exampleRequest -> exampleService.updateExample(exampleRequest.id(),exampleRequest)).toList();
    }

    public List<TestCaseResponse> updateTestCass(Long problemId,List<TestCaseRequest> testCaseRequests){
        problemRepository.findById(problemId).orElseThrow(()->new ProblemNotFoundException(problemId));
        return testCaseRequests.stream().map(testCaseRequest -> testCaseService.updateTestCase(testCaseRequest.id(), testCaseRequest)).toList();
    }

    public List<ProblemTagResponse> updateProblemTags(Long problemId,List<ProblemTagRequest> problemTagRequests){
        problemRepository.findById(problemId).orElseThrow(()->new ProblemNotFoundException(problemId));
        return problemTagRequests.stream().map(problemTagRequest -> problemTagService.updateProblemTag(problemTagRequest.id(), problemTagRequest)).toList();
    }

    public EditorialResponse updateEditorial(Long problemId,EditorialRequest editorialRequest){
        problemRepository.findById(problemId).orElseThrow(()->new ProblemNotFoundException(problemId));
        return editorialService.updateEditorial(editorialRequest.id(),editorialRequest);
    }

    public ProblemDetailsResponse createFullProblem(FullProblemRequest fullProblemRequest){
        ProblemResponse problem=adminProblemService.createProblem(problemMapper.toProblemRequest(fullProblemRequest));
        Long problemId=problem.id();
        createExamples(problemId,fullProblemRequest.exampleRequestList());
        createTestCases(problemId,fullProblemRequest.testCaseRequestList());
        createEditorial(problemId,fullProblemRequest.editorialRequest());
        createProblemTags(problemId,fullProblemRequest.problemTagRequests());

        Problem fullProblem=problemRepository.findById(problemId).orElseThrow(()->new ProblemNotFoundException(problemId));

        return problemMapper.toDetailsResponse(fullProblem);
    }

    public ProblemDetailsResponse updateFullProblem(Long problemId,FullProblemRequest fullProblemRequest) {
        ProblemResponse problemResponse=adminProblemService.updateProblem(problemId,problemMapper.toProblemRequest(fullProblemRequest));
        updateExamples(problemId,fullProblemRequest.exampleRequestList());
        updateTestCass(problemId,fullProblemRequest.testCaseRequestList());
        updateProblemTags(problemId,fullProblemRequest.problemTagRequests());
        updateEditorial(problemId,fullProblemRequest.editorialRequest());
        Problem fullProblem=problemRepository.findById(problemId).orElseThrow(()->new ProblemNotFoundException(problemResponse.id()));
        return problemMapper.toDetailsResponse(fullProblem);
    }

    public void editExamples(Long problemId, List<ExamplePatchRequest> examplePatchRequests){
        problemRepository.findById(problemId).orElseThrow(()->new ProblemNotFoundException(problemId));
        examplePatchRequests.forEach(examplePatchRequest -> exampleService.editExample(
                examplePatchRequest.id(),examplePatchRequest));
    }

    public void editTestCases(Long problemId, List<TestCasePatchRequest> testCasePatchRequests){
        problemRepository.findById(problemId).orElseThrow(()->new ProblemNotFoundException(problemId));
        testCasePatchRequests.forEach(testCasePatchRequest -> testCaseService.editTestCase(
                testCasePatchRequest.id(),testCasePatchRequest));
    }

    public void editProblemTags(Long problemId,List<ProblemTagRequest> problemTagRequests){
        problemRepository.findById(problemId).orElseThrow(()->new ProblemNotFoundException(problemId));
        problemTagRequests.forEach(problemTagRequest -> problemTagService.editProblemTag(
                problemTagRequest.id(),problemTagRequest));
    }

    public void editEditorial(Long problemId, EditorialPatchRequest editorialPatchRequest){
        problemRepository.findById(problemId).orElseThrow(()->new ProblemNotFoundException(problemId));
        editorialService.editEditorial(editorialPatchRequest.id(),editorialPatchRequest);
    }

    public void deleteExample(Long problemId,Long exampleId){
        problemRepository.findById(problemId).orElseThrow(()->new ProblemNotFoundException(problemId));
        exampleService.deleteExample(exampleId);
    }

    public void deleteTestCase(Long problemId,Long TestCaseId){
        problemRepository.findById(problemId).orElseThrow(()->new ProblemNotFoundException(problemId));
        testCaseService.deleteTestCase(TestCaseId);
    }

    public void deleteEditorial(Long problemId,Long editorialId){
        problemRepository.findById(problemId).orElseThrow(()->new ProblemNotFoundException(problemId));
        editorialService.deleteEditorial(editorialId);
    }

    public void deleteProblemTag(Long problemId, Long problemTagId) {
        problemRepository.findById(problemId).orElseThrow(()->new ProblemNotFoundException(problemId));
        problemTagService.deleteEditorial(problemTagId);
    }

    public void deleteProblem(Long problemId) {
        Problem problem=problemRepository.findById(problemId).orElseThrow(()->new ProblemNotFoundException(problemId));
        problemRepository.delete(problem);
    }
}
