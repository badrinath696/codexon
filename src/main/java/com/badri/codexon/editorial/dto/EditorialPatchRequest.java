package com.badri.codexon.editorial.dto;

public record EditorialPatchRequest(
        Long id,
        String title,
        String explanation,
        String code,
        String language
) {
}
