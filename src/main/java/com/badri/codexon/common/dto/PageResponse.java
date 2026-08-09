package com.badri.codexon.common.dto;

import org.springframework.data.domain.Page;

import java.util.List;

public record PageResponse<T>(
        int page,
        int size,
        boolean first,
        boolean last,
        long totalElements,
        int totalPages,
        List<T> content
) {
    public static <T> PageResponse<T> toPageResponse(Page<T> pages){
        return new PageResponse<>(
            pages.getNumber(),
            pages.getSize(),
            pages.isFirst(),
            pages.isLast(),
            pages.getTotalElements(),
            pages.getTotalPages(),
            pages.getContent()
        );
    }
}
