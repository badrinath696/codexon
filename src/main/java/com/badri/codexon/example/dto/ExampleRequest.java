package com.badri.codexon.example.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

public record ExampleRequest(
        @Nullable
        Long id,
        @NotBlank
        String inputData,
        @NotBlank
        String outputData,
        @Nullable
        String explanation
) {
}
