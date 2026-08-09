package com.badri.codexon.tags.service;

import com.badri.codexon.tags.dto.TagRequest;
import com.badri.codexon.tags.dto.TagResponse;
import com.badri.codexon.tags.entity.Tags;
import com.badri.codexon.tags.mapper.TagMapper;
import com.badri.codexon.tags.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    public TagResponse createTag(TagRequest request){
        Tags tag=tagMapper.toTag(request);
        return tagMapper.toResponse(tagRepository.save(tag));
    }

}
