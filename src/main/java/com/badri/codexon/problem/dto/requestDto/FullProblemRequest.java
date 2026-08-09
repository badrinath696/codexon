package com.badri.codexon.problem.dto.requestDto;

import com.badri.codexon.common.enums.Difficulty;
import com.badri.codexon.common.enums.ProblemStatus;
import com.badri.codexon.editorial.dto.EditorialRequest;
import com.badri.codexon.example.dto.ExampleRequest;
import com.badri.codexon.problem.entity.ProblemTag;
import com.badri.codexon.tags.dto.TagRequest;
import com.badri.codexon.tags.entity.Tags;
import com.badri.codexon.testcase.dto.TestCaseRequest;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;

import java.util.List;

public record FullProblemRequest(
        @Nullable
        Long id,
        @NotBlank
        @Size(max=150,message = "Title too long")
        String title,
        @NotBlank
        String description,
        @NotBlank
        String constraints,
        @NotNull
        Difficulty difficulty,
        @NotNull
        @Positive
        Integer timeLimitMs,
        @NotNull
        @Positive
        Integer memoryLimitMb,
        @NotEmpty
        List<ExampleRequest> exampleRequestList,
        @NotEmpty
        List<TestCaseRequest> testCaseRequestList,
        @NotEmpty
        List<ProblemTagRequest> problemTagRequests,
        EditorialRequest editorialRequest
) {
}
