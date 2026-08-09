package com.badri.codexon.submission.dto.runDto;

import com.badri.codexon.common.enums.Verdict;

import java.util.List;

public record RunCodeResponse(
        Verdict verdict,
        Integer totalTestCases,
        Integer passedTestCases,
        Integer executionTimeMs,
        Integer memoryUsedKb,
        String compilerMessage,
        List<RunTestCaseResult> testCaseResults
) {
}
