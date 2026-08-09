package com.badri.codexon.testcase.dto;

import com.badri.codexon.common.enums.TestCaseType;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TestCaseRequest(
        @Nullable
        Long id,
        @NotBlank
        String inputData,
        @NotBlank
        String expectedOutput,
        @NotNull
        Boolean hidden
) {
}
