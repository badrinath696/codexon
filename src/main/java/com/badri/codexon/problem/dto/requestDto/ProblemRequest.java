package com.badri.codexon.problem.dto.requestDto;

import com.badri.codexon.common.enums.Difficulty;
import com.badri.codexon.common.enums.ProblemStatus;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProblemRequest(
        @Nullable
        Long id,
        @Size(max=150,message = "Title too long!")
        @NotBlank(message="Title Required")
        String title,
        @NotBlank(message = "Description required")
        @Size(max=100_000,message = "Description too long!")
        String description,
        @NotNull(message = "Provide Difficulty level")
        Difficulty difficulty,
        @NotNull
        @NotBlank
        String constraints,
        @NotNull
        @Positive
        Integer timeLimitMs,
        @NotNull
        @Positive
        Integer memoryLimitMb
) {
}
