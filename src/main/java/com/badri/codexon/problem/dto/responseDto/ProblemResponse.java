package com.badri.codexon.problem.dto.responseDto;

import com.badri.codexon.common.enums.Difficulty;
import com.badri.codexon.common.enums.ProblemStatus;

import java.time.LocalDateTime;

public record ProblemResponse(
        Long id,
        String title,
        String description,
        Difficulty difficulty,
        String constraints,
        Integer timeLimitMs,
        Integer memoryLimitMb,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        ProblemStatus problemStatus
) {
}
