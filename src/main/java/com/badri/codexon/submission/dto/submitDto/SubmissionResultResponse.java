package com.badri.codexon.submission.dto.submitDto;

import com.badri.codexon.common.enums.SubmissionStatus;
import com.badri.codexon.common.enums.Verdict;

import java.time.LocalDateTime;

public record SubmissionResultResponse(
        Long submissionId,
        Integer passedTestCases,
        int totalTestCases,
        Verdict verdict,
        String compilerMessage,
        Integer peakMemoryUsedKb,
        Integer peakExecutionTime,
        SubmissionStatus status,
        LocalDateTime submittedAt
) {
}
