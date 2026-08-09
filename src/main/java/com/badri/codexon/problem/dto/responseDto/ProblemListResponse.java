package com.badri.codexon.problem.dto.responseDto;

import com.badri.codexon.common.enums.Difficulty;
import com.badri.codexon.common.enums.ProblemSolvedStatus;

public record ProblemListResponse(
        Long id,
        String title,
        Integer problemNumber,
        Difficulty difficulty,
        Double acceptanceRate,
        boolean premiumOnly,
        boolean bookMarked,
        ProblemSolvedStatus status
) {
}
