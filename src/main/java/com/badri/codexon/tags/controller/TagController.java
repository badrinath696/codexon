package com.badri.codexon.tags.controller;

import com.badri.codexon.tags.dto.TagRequest;
import com.badri.codexon.tags.dto.TagResponse;
import com.badri.codexon.tags.service.TagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin/tag")
public class TagController {

    private final TagService tagService;

    @PostMapping("/create")
    ResponseEntity<TagResponse> createTag(@RequestBody @Valid TagRequest tagRequest){
        return ResponseEntity.ok(tagService.createTag(tagRequest));
    }

}
