package com.badri.codexon.testcase.service;

import com.badri.codexon.common.exception.ProblemNotFoundException;
import com.badri.codexon.common.exception.TestCaseNotFoundException;
import com.badri.codexon.problem.entity.Problem;
import com.badri.codexon.problem.repository.ProblemRepository;
import com.badri.codexon.testcase.dto.TestCasePatchRequest;
import com.badri.codexon.testcase.dto.TestCaseRequest;
import com.badri.codexon.testcase.dto.TestCaseResponse;
import com.badri.codexon.testcase.entity.TestCase;
import com.badri.codexon.testcase.mapper.TestCaseMapper;
import com.badri.codexon.testcase.repository.TestCaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestCaseService {

    private final TestCaseRepository testCaseRepository;
    private final TestCaseMapper testCaseMapper;
    private final ProblemRepository problemRepository;

    public TestCaseResponse createTestCase(Problem problem,TestCaseRequest request){
        TestCase testCase=testCaseMapper.toTestCase(request);
        testCase.setProblem(problem);
        return testCaseMapper.toTestCaseResponse(testCaseRepository.save(testCase));
    }

    public TestCaseResponse updateTestCase(Long id, TestCaseRequest testCaseRequest) {
        TestCase testCase=testCaseRepository.findById(id).orElseThrow(()->new TestCaseNotFoundException(id));
        testCase.setHidden(testCaseRequest.hidden());
        testCase.setInputData(testCaseRequest.inputData());
        testCase.setExpectedOutput(testCaseRequest.expectedOutput());
        return testCaseMapper.toTestCaseResponse(testCase);
    }

    public void editTestCase(Long testCaseId, TestCasePatchRequest testCasePatchRequest){
        TestCase testCase=testCaseRepository.findById(testCaseId).orElseThrow(()->new TestCaseNotFoundException(testCaseId));
        testCaseMapper.editTestCase(testCase,testCasePatchRequest);
    }

    public void deleteTestCase(Long testCaseId) {
        TestCase testCase=testCaseRepository.findById(testCaseId).orElseThrow(()->new TestCaseNotFoundException(testCaseId));
        testCaseRepository.delete(testCase);
    }
}
