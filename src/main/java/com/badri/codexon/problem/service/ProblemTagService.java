package com.badri.codexon.problem.service;

import com.badri.codexon.common.exception.ProblemTagNotFoundException;
import com.badri.codexon.common.exception.TagNotFoundException;
import com.badri.codexon.problem.dto.requestDto.ProblemTagRequest;
import com.badri.codexon.problem.dto.responseDto.ProblemTagResponse;
import com.badri.codexon.problem.entity.Problem;
import com.badri.codexon.problem.entity.ProblemTag;
import com.badri.codexon.problem.mapper.ProblemMapper;
import com.badri.codexon.problem.repository.ProblemTagRepository;
import com.badri.codexon.tags.entity.Tags;
import com.badri.codexon.tags.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProblemTagService {

    private final TagRepository tagRepository;
    private final ProblemTagRepository problemTagRepository;
    private final ProblemMapper problemMapper;

    @Transactional
    public ProblemTagResponse createProblemTag(Problem problem, Long tagId){
        Tags tag=tagRepository.findById(tagId).orElseThrow(()->new TagNotFoundException(tagId));
        ProblemTag problemTag=new ProblemTag();
        problemTag.setProblem(problem);
        problemTag.setTag(tag);
        return problemMapper.toProblemTagResponse((problemTagRepository.save(problemTag)).getTag());
    }

    @Transactional
    public ProblemTagResponse updateProblemTag(Long id,ProblemTagRequest problemTagRequest) {
        ProblemTag problemTag=problemTagRepository.findById(id).orElseThrow(()->new ProblemTagNotFoundException(id));
        Tags tag=tagRepository.findById(problemTagRequest.tagId()).orElseThrow(()->new TagNotFoundException(problemTagRequest.tagId()));
        problemTag.setTag(tag);
        return problemMapper.toProblemTagResponse(problemTag.getTag());
    }

    @Transactional
    public void editProblemTag(Long problemTagId, ProblemTagRequest problemTagRequest){
        ProblemTag problemTag=problemTagRepository.findById(problemTagId).orElseThrow(()->new ProblemTagNotFoundException(problemTagId));
        Tags tag=tagRepository.findById(problemTagRequest.tagId()).orElseThrow(()->new TagNotFoundException(
                problemTagRequest.tagId()));
        problemTag.setTag(tag);
    }

    public void deleteProblemTag(Long problemTagId) {
        ProblemTag problemTag=problemTagRepository.findById(problemTagId).orElseThrow(()->new ProblemTagNotFoundException(problemTagId));
        problemTagRepository.delete(problemTag);
    }
}
