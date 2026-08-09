package com.badri.codexon.problem.mapper;

import com.badri.codexon.example.entity.Example;
import com.badri.codexon.problem.dto.requestDto.FullProblemRequest;
import com.badri.codexon.problem.dto.requestDto.ProblemPatchRequest;
import com.badri.codexon.problem.dto.requestDto.ProblemRequest;
import com.badri.codexon.problem.dto.responseDto.ProblemDetailsResponse;
import com.badri.codexon.problem.dto.responseDto.ProblemListResponse;
import com.badri.codexon.problem.dto.responseDto.ProblemResponse;
import com.badri.codexon.problem.dto.responseDto.ProblemTagResponse;
import com.badri.codexon.problem.entity.Problem;
import com.badri.codexon.problem.entity.ProblemTag;
import com.badri.codexon.tags.dto.TagResponse;
import com.badri.codexon.tags.entity.Tags;
import com.badri.codexon.testcase.entity.TestCase;
import org.mapstruct.*;

import java.util.List;


@Mapper(componentModel ="spring")
public interface ProblemMapper {

    @Mapping(source = "problemTags", target = "tags")
    ProblemDetailsResponse toDetailsResponse(Problem problem);
    ProblemListResponse toListResponse(Problem problem);
    ProblemResponse toProblemResponse(Problem problem);
    Problem toProblem(ProblemRequest problemRequest);
    ProblemRequest toProblemRequest(FullProblemRequest fullProblemRequest);
    ProblemTagResponse toProblemTagResponse(Tags tag);

    @Mapping(source = "tag.id", target = "id")
    @Mapping(source = "tag.name", target = "name")
    TagResponse toTagResponse(ProblemTag problemTag);

    @Mapping(source = "examples", target = "examples")
    @Mapping(source = "testCases", target = "testCases")
    @Mapping(source = "problem.problemTags", target = "tags")
    ProblemDetailsResponse toDetailsResponseForUser(Problem problem, List<Example> examples, List<TestCase> testCases);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void editProblem(@MappingTarget Problem problem, ProblemPatchRequest problemPatchRequest);

}
