package com.badri.codexon.example.service;

import com.badri.codexon.common.exception.ExampleNotFoundException;
import com.badri.codexon.example.dto.ExamplePatchRequest;
import com.badri.codexon.example.dto.ExampleRequest;
import com.badri.codexon.example.dto.ExampleResponse;
import com.badri.codexon.example.entity.Example;
import com.badri.codexon.example.mapper.ExampleMapper;
import com.badri.codexon.example.repository.ExampleRepository;
import com.badri.codexon.problem.entity.Problem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExampleService {

    private final ExampleRepository exampleRepository;
    private final ExampleMapper exampleMapper;

    public ExampleResponse createExample(Problem problem,ExampleRequest exampleRequest){
        Example example=exampleMapper.toExample(exampleRequest);
        example.setProblem(problem);
        return exampleMapper.toResponse(exampleRepository.save(example));
    }

    @Transactional
    public ExampleResponse updateExample(Long exampleId,ExampleRequest exampleRequest){
        Example example=exampleRepository.findById(exampleId).orElseThrow(()->new ExampleNotFoundException(exampleId));
        example.setInputData(exampleRequest.inputData());
        example.setOutputData(exampleRequest.outputData());
        example.setExplanation(exampleRequest.explanation());
        return exampleMapper.toResponse(example);
    }

    @Transactional
    public void editExample(Long exampleId, ExamplePatchRequest examplePatchRequest){
        Example example=exampleRepository.findById(exampleId).orElseThrow(()->new ExampleNotFoundException(exampleId));
        if(examplePatchRequest.inputData()!=null){
            example.setInputData(examplePatchRequest.inputData());
        }
        if(examplePatchRequest.outputData()!=null){
            example.setOutputData(examplePatchRequest.outputData());
        }
        if(examplePatchRequest.explanation()!=null){
            example.setExplanation(examplePatchRequest.explanation());
        }
    }

    @Transactional
    public void deleteExample(Long exampleId){
        Example example=exampleRepository.findById(exampleId).orElseThrow(()->new ExampleNotFoundException(exampleId));
        exampleRepository.delete(example);
    }

}
