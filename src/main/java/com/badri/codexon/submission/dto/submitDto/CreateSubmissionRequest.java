package com.badri.codexon.submission.dto.submitDto;

import com.badri.codexon.common.enums.ProgramLanguage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateSubmissionRequest(
        @NotBlank(message = "code needed")
        @Size(max=100_000,message = "Source code too large")
        String sourceCode,
        @NotNull(message = "select language")
        ProgramLanguage language
) {
}
