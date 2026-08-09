package com.badri.codexon.problem.controller;

import com.badri.codexon.editorial.dto.EditorialPatchRequest;
import com.badri.codexon.editorial.dto.EditorialRequest;
import com.badri.codexon.editorial.dto.EditorialResponse;
import com.badri.codexon.example.dto.ExamplePatchRequest;
import com.badri.codexon.example.dto.ExampleRequest;
import com.badri.codexon.example.dto.ExampleResponse;
import com.badri.codexon.problem.dto.requestDto.FullProblemRequest;
import com.badri.codexon.problem.dto.requestDto.ProblemPatchRequest;
import com.badri.codexon.problem.dto.requestDto.ProblemRequest;
import com.badri.codexon.problem.dto.requestDto.ProblemTagRequest;
import com.badri.codexon.problem.dto.responseDto.ProblemDetailsResponse;
import com.badri.codexon.problem.dto.responseDto.ProblemResponse;
import com.badri.codexon.problem.dto.responseDto.ProblemTagResponse;
import com.badri.codexon.problem.service.AdminProblemOrchestra;
import com.badri.codexon.problem.service.AdminProblemService;
import com.badri.codexon.testcase.dto.TestCasePatchRequest;
import com.badri.codexon.testcase.dto.TestCaseRequest;
import com.badri.codexon.testcase.dto.TestCaseResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/problem")
public class AdminProblemController {

    private final AdminProblemService adminProblemService;
    private final AdminProblemOrchestra adminProblemOrchestra;

    public AdminProblemController(AdminProblemService adminProblemService,AdminProblemOrchestra adminProblemOrchestra){
        this.adminProblemService=adminProblemService;
        this.adminProblemOrchestra=adminProblemOrchestra;
    }

    @PostMapping("/create")
    private ResponseEntity<ProblemResponse> createProblem(@RequestBody @Valid ProblemRequest request){
        return ResponseEntity.ok(adminProblemService.createProblem(request));
    }
    @PostMapping("/{problemId}/create/examples")
    private ResponseEntity<List<ExampleResponse>> createExamples(@PathVariable Long problemId,
                                                                 @RequestBody @Valid List<ExampleRequest> exampleRequests){
        return ResponseEntity.ok(adminProblemOrchestra.createExamples(problemId,exampleRequests));
    }

    @PostMapping("/{problemId}/create/testCases")
    private ResponseEntity<List<TestCaseResponse>> createTestCases(@PathVariable Long problemId,
                                                                   @RequestBody @Valid List<TestCaseRequest> testCaseRequests){
        return ResponseEntity.ok(adminProblemOrchestra.createTestCases(problemId,testCaseRequests));
    }

    @PostMapping("/{problemId}/create/editorial")
    private ResponseEntity<EditorialResponse> createEditorial(@PathVariable Long problemId,
                                                              @RequestBody @Valid EditorialRequest editorialRequest){
        return ResponseEntity.ok(adminProblemOrchestra.createEditorial(problemId,editorialRequest));
    }

    @PostMapping("/{problemId}/create/problemTags")
    private ResponseEntity<List<ProblemTagResponse>> createProblemTags(@PathVariable Long problemId,@RequestBody @Valid List<ProblemTagRequest> tagIds){
        return ResponseEntity.ok(adminProblemOrchestra.createProblemTags(problemId,tagIds));
    }

    @PostMapping("/create/fullProblem")
    private ResponseEntity<ProblemDetailsResponse> createFullProblem(@RequestBody @Valid FullProblemRequest fullProblemRequest){
        return ResponseEntity.ok(adminProblemOrchestra.createFullProblem(fullProblemRequest));
    }

    @PutMapping("/{problemId}/update/fullProblem")
    private ResponseEntity<ProblemDetailsResponse> updateFullProblem(@PathVariable Long problemId,@RequestBody @Valid FullProblemRequest fullProblemRequest){
        return ResponseEntity.ok(adminProblemOrchestra.updateFullProblem(problemId,fullProblemRequest));
    }

    @PutMapping("/{problemId}/update/problem")
    private ResponseEntity<ProblemResponse> updateProblem(@PathVariable Long problemId,@RequestBody @Valid ProblemRequest problemRequest){
        return ResponseEntity.ok(adminProblemService.updateProblem(problemId,problemRequest));
    }

    @PutMapping("/{problemId}/update/examples")
    private ResponseEntity<List<ExampleResponse>> updateExamples(@PathVariable Long problemId, @RequestBody @Valid List<ExampleRequest> exampleRequests){
        return ResponseEntity.ok(adminProblemOrchestra.updateExamples(problemId,exampleRequests));
    }

    @PutMapping("/{problemId}/update/testCases")
    private ResponseEntity<List<TestCaseResponse>> updateTestCases(@PathVariable Long problemId,@RequestBody @Valid List<TestCaseRequest> testCaseRequests){
        return ResponseEntity.ok(adminProblemOrchestra.updateTestCass(problemId,testCaseRequests));
    }

    @PutMapping("/{problemId}/update/problemTags")
    private ResponseEntity<List<ProblemTagResponse>> updateProblemTags(@PathVariable Long problemId,@RequestBody @Valid List<ProblemTagRequest> problemTagRequests){
        return ResponseEntity.ok(adminProblemOrchestra.updateProblemTags(problemId,problemTagRequests));
    }

    @PutMapping("/{problemId}/update/editorial")
    private ResponseEntity<EditorialResponse> updateEditorial(@PathVariable Long problemId,@RequestBody @Valid EditorialRequest editorialRequest){
        return ResponseEntity.ok(adminProblemOrchestra.updateEditorial(problemId,editorialRequest));
    }

    @PatchMapping("/{problemId}/edit/problem")
    private ResponseEntity<String> editProblem(@PathVariable Long problemId, @RequestBody ProblemPatchRequest problemPatchRequest){
        adminProblemService.editProblem(problemId,problemPatchRequest);
        return ResponseEntity.ok("Problem Updated Successfully!");
    }

    @PatchMapping("/{problemId}/edit/examples")
    private ResponseEntity<String> editExamples(@PathVariable Long problemId, @RequestBody List<ExamplePatchRequest> examplePatchRequests){
        adminProblemOrchestra.editExamples(problemId,examplePatchRequests);
        return ResponseEntity.ok("Examples Updated successfully!");
    }

    @PatchMapping("/{problemId}/edit/testCases")
    private ResponseEntity<String> editTestCases(@PathVariable Long problemId,@RequestBody List<TestCasePatchRequest> testCasePatchRequests){
        adminProblemOrchestra.editTestCases(problemId,testCasePatchRequests);
        return ResponseEntity.ok("TestCase Updated successfully!");
    }

    @PatchMapping("/{problemId}/edit/problemTags")
    private ResponseEntity<String> editProblemTags(@PathVariable Long problemId,@RequestBody List<ProblemTagRequest> problemTagRequests){
        adminProblemOrchestra.editProblemTags(problemId,problemTagRequests);
        return ResponseEntity.ok("ProblemTags updated successFully!");
    }

    @PatchMapping("/{problemId}/edit/editoral")
    private ResponseEntity<String> editEditorial(@PathVariable Long problemId, EditorialPatchRequest editorialPatchRequest){
        adminProblemOrchestra.editEditorial(problemId,editorialPatchRequest);
        return ResponseEntity.ok("Editorial Updated Successfully!");
    }

    @DeleteMapping("/{problemId}/example/{exampleId}/delete")
    private ResponseEntity<String> deleteExample(@PathVariable Long problemId,@PathVariable Long exampleId){
        adminProblemOrchestra.deleteExample(problemId,exampleId);
        return ResponseEntity.ok("Example with id: "+exampleId+" is Deleted!");
    }

    @DeleteMapping("/{problemId}/testCase/{testCaseId}/delete")
    private ResponseEntity<String> deleteTestCase(@PathVariable Long problemId,@PathVariable Long testCaseId){
        adminProblemOrchestra.deleteTestCase(problemId,testCaseId);
        return ResponseEntity.ok("Example with id: "+testCaseId+" is Deleted!");
    }

    @DeleteMapping("/{problemId}/problemTag/{problemTagId}/delete")
    private ResponseEntity<String> deleteProblemTag(@PathVariable Long problemId,@PathVariable Long problemTagId){
        adminProblemOrchestra.deleteProblemTag(problemId,problemTagId);
        return ResponseEntity.ok("Example with id: "+problemTagId+" is Deleted!");
    }

    @DeleteMapping("/{problemId}/editorial/{editorialId}/delete")
    private ResponseEntity<String> deleteEditorial(@PathVariable Long problemId,@PathVariable Long editorialId){
        adminProblemOrchestra.deleteEditorial(problemId,editorialId);
        return ResponseEntity.ok("Example with id: "+editorialId+" is Deleted!");
    }

    @DeleteMapping("/{problemId}/delete")
    private ResponseEntity<String> deleteProblem(@PathVariable Long problemId){
        adminProblemOrchestra.deleteProblem(problemId);
        return ResponseEntity.ok("Example with id: "+problemId+" is Deleted!");
    }

}
