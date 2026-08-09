package com.badri.codexon.testcase.dto;

public record TestCaseResponse(
        Long id,
        String inputData,
        String expectedOutput
) {
}
