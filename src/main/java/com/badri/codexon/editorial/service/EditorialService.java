package com.badri.codexon.editorial.service;

import com.badri.codexon.common.enums.ProgramLanguage;
import com.badri.codexon.common.exception.EditorialNotFoundException;
import com.badri.codexon.common.exception.ProblemNotFoundException;
import com.badri.codexon.editorial.dto.EditorialPatchRequest;
import com.badri.codexon.editorial.dto.EditorialRequest;
import com.badri.codexon.editorial.dto.EditorialResponse;
import com.badri.codexon.editorial.entity.Editorial;
import com.badri.codexon.editorial.mapper.EditorialMapper;
import com.badri.codexon.editorial.repository.EditorialRepository;
import com.badri.codexon.problem.entity.Problem;
import com.badri.codexon.problem.repository.ProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditorialService {

    private final EditorialRepository editorialRepository;
    private final EditorialMapper editorialMapper;
    private final ProblemRepository problemRepository;

    public EditorialResponse createEditorial(Long id,EditorialRequest request){
        Problem problem=problemRepository.findById(id).orElseThrow(()->new ProblemNotFoundException(id));
        Editorial editorial=editorialMapper.toEditorial(request);
        editorial.setProblem(problem);
        return editorialMapper.toResponse(editorialRepository.save(editorial));
    }

    public EditorialResponse updateEditorial(Long id,EditorialRequest request){
        Editorial editorial=editorialRepository.findById(id).orElseThrow(()->new EditorialNotFoundException(id));
        editorial.setTitle(request.title());
        editorial.setExplanation(request.explanation());
        editorial.setCode(request.code());
        editorial.setLanguage(ProgramLanguage.valueOf(request.language()));
        return editorialMapper.toResponse(editorial);
    }

    public void editEditorial(Long editorialId, EditorialPatchRequest editorialPatchRequest) {
        Editorial editorial=editorialRepository.findById(editorialId).orElseThrow(()->new EditorialNotFoundException(editorialId));
        editorialMapper.editEditorial(editorial,editorialPatchRequest);
    }

    public void deleteEditorial(Long editorialId) {
        Editorial editorial=editorialRepository.findById(editorialId).orElseThrow(()->new EditorialNotFoundException(editorialId));
        editorialRepository.delete(editorial);
    }
}
