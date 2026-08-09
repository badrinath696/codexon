package com.badri.codexon.judgeEngine.dto;

import com.badri.codexon.common.enums.Verdict;

public record JudgeTestCaseResult(
        Long testCaseId,
        Verdict verdict,
        Integer executionTimeMs,
        Integer memoryUsedKb,
        String actualOutput,
        String errorMessage
) {
}
