package com.badri.codexon.problem.dto.requestDto;

import com.badri.codexon.common.enums.Difficulty;

public record ProblemPatchRequest(
        String title,
        String description,
        Difficulty difficulty,
        String constraints,
        Integer timeLimitMs,
        Integer memoryLimitMb
) {
}
