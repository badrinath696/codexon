package com.badri.codexon.submission.dto.runDto;

import com.badri.codexon.common.enums.ProgramLanguage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RunCodeRequest(
        @NotBlank(message = "Source Code Required")
        @Size(max=100_000,message = "Source code too long!")
        String sourcecode,
        @NotNull(message = "Language Required")
        ProgramLanguage language
) {
}
