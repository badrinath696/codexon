package com.badri.codexon.judgeEngine.dto;

import com.badri.codexon.common.enums.JudgeStatus;
import com.badri.codexon.common.enums.Verdict;

import java.util.List;

public record JudgeExecutionResponse(
       Integer peakMemoryUsedKb,
       Integer totalExecutionTimeMs,
       Verdict finalVerdict,
       String compilerMessage,
       JudgeStatus status,
       List<JudgeTestCaseResult> testCaseResults
) {
}
