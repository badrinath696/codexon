package com.badri.codexon.submission.dto.submitDto;

import com.badri.codexon.common.dto.PageResponse;
import com.badri.codexon.common.enums.ProgramLanguage;
import com.badri.codexon.common.enums.SubmissionStatus;
import com.badri.codexon.common.enums.Verdict;

import java.time.LocalDateTime;

public record SubmissionListResponse(
        Integer submissionNumber,
        Long id,
        ProgramLanguage language,
        Integer executionTimeMs,
        Integer peakMemoryUsedKb,
        SubmissionStatus status,
        Verdict verdict,
        LocalDateTime submittedAt
) {
}
