package com.badri.codexon.testcase.dto;

public record TestCasePatchRequest(
        Long id,
        String inputData,
        String expectedOutput,
        Boolean hidden
) {
}
