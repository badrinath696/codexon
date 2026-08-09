package com.badri.codexon.editorial.dto;

import com.badri.codexon.common.enums.ProgramLanguage;

import java.time.LocalDateTime;

public record EditorialResponse(
        String title,
        String explanation,
        String code,
        ProgramLanguage language,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
