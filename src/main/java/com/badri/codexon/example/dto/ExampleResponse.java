package com.badri.codexon.example.dto;

import jakarta.annotation.Nullable;

public record ExampleResponse(
        Long id,
        String inputData,
        String outputData,
        @Nullable
        String explanation
) {
}
