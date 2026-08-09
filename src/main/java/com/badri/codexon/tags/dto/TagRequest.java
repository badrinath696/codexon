package com.badri.codexon.tags.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TagRequest(
        @NotNull
        @NotBlank
        @Size(max=50,message = "Tag is Too long!")
        String name
) {
}
