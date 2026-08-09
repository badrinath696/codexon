package com.badri.codexon.testcase.mapper;

import com.badri.codexon.testcase.dto.TestCasePatchRequest;
import com.badri.codexon.testcase.dto.TestCaseRequest;
import com.badri.codexon.testcase.dto.TestCaseResponse;
import com.badri.codexon.testcase.entity.TestCase;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel ="spring")
public interface TestCaseMapper {

    TestCase toTestCase(TestCaseRequest testCaseRequest);
    TestCaseResponse toTestCaseResponse(TestCase testCase);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void editTestCase(@MappingTarget TestCase testCase, TestCasePatchRequest testCasePatchRequest);

}
