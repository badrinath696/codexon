package com.badri.codexon.editorial.mapper;

import com.badri.codexon.editorial.dto.EditorialPatchRequest;
import com.badri.codexon.editorial.dto.EditorialRequest;
import com.badri.codexon.editorial.dto.EditorialResponse;
import com.badri.codexon.editorial.entity.Editorial;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.BeanMapping;

@Mapper(componentModel ="spring")
public interface EditorialMapper {

    Editorial toEditorial(EditorialRequest request);
    EditorialResponse toResponse(Editorial editorial);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void editEditorial(@MappingTarget Editorial editorial, EditorialPatchRequest editorialPatchRequest);

}
