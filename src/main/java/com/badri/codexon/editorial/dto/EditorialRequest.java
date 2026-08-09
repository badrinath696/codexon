package com.badri.codexon.editorial.dto;

import com.badri.codexon.common.enums.ProgramLanguage;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EditorialRequest(
        @Nullable
        Long id,
        @NotBlank
        @Size(max=150)
        String title,
        @NotBlank
        @Size(max=100_000)
        String explanation,
        @NotBlank
        @Size(max=100_000)
        String code,
        @NotNull
        String language
) {
}
