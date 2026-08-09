package com.badri.codexon.submission.dto.runDto;

import com.badri.codexon.common.enums.Verdict;

public record RunTestCaseResult(
        Integer testCaseNumber,
        Verdict verdict,
        String input,
        String actualOutput,
        String expectedOutput,
        Integer executionTimeMs,
        Integer memoryUsedKb,
        String errorMessage
) {
}
