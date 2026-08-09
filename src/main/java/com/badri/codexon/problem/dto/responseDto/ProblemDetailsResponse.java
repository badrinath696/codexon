package com.badri.codexon.problem.dto.responseDto;

import com.badri.codexon.common.enums.Difficulty;
import com.badri.codexon.editorial.dto.EditorialResponse;
import com.badri.codexon.example.dto.ExampleResponse;
import com.badri.codexon.tags.dto.TagResponse;
import com.badri.codexon.testcase.dto.TestCaseResponse;

import java.util.List;


public record ProblemDetailsResponse(
        Long id,
        String title,
        String description,
        Difficulty difficulty,
        String constraints,
        List<ExampleResponse> examples,
        List<TagResponse> tags,
        List<TestCaseResponse> testCases,
        EditorialResponse editorial
) {
}
