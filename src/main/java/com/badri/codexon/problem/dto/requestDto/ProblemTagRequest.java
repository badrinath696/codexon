package com.badri.codexon.problem.dto.requestDto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;


public record ProblemTagRequest(
        @Nullable
        Long id,
        @NotNull
        Long tagId
) {
}
