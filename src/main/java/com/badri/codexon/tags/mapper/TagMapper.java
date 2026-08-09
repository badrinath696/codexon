package com.badri.codexon.tags.mapper;

import com.badri.codexon.tags.dto.TagRequest;
import com.badri.codexon.tags.dto.TagResponse;
import com.badri.codexon.tags.entity.Tags;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")
public interface TagMapper {

    Tags toTag(TagRequest tagRequest);
    TagResponse toResponse(Tags tag);

}
