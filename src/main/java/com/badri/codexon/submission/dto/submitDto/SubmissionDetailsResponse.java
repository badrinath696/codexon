package com.badri.codexon.submission.dto.submitDto;

import com.badri.codexon.common.enums.ProgramLanguage;
import com.badri.codexon.common.enums.SubmissionStatus;
import com.badri.codexon.common.enums.Verdict;

import java.time.LocalDateTime;

public record SubmissionDetailsResponse(
        Long submissionId,
        Long problemId,
        String problemTitle,
        String sourceCode,
        ProgramLanguage language,
        Integer memoryUsedKb,
        Integer executionTime,
        Verdict verdict,
        SubmissionStatus status,
        Integer passedTestCases,
        Integer totalTestCases,
        LocalDateTime submittedAt
) {
}
