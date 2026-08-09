package com.badri.codexon.judgeEngine.dto;

import com.badri.codexon.common.enums.ProgramLanguage;
import java.util.List;

public record JudgeExecutionRequest(
        String sourceCode,
        ProgramLanguage language,
        Integer timeLimitMs,
        Integer memoryLimitMb,
        List<JudgeTestCaseRequest> testCases
) {
}
