package com.badri.codexon.judgeEngine.dto;

public record JudgeTestCaseRequest(
        Long testCaseId,
        String input,
        String expectedOutput
) {
}
