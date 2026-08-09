package com.badri.codexon.example.mapper;

import com.badri.codexon.example.dto.ExampleRequest;
import com.badri.codexon.example.dto.ExampleResponse;
import com.badri.codexon.example.entity.Example;
import org.mapstruct.Mapper;


@Mapper(componentModel ="spring")
public interface ExampleMapper {

    Example toExample(ExampleRequest exampleRequest);
    ExampleResponse toResponse(Example example);


}
