package com.badri.codexon.example.dto;

public record ExamplePatchRequest(
        Long id,
        String inputData,
        String outputData,
        String explanation
) {
}
