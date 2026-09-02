package com.badri.codexon.common.exception;

public class ProblemTagNotFoundException extends BusinessException {
    public ProblemTagNotFoundException(Long id) {
        super("There is no ProblemTag with id:"+id);
    }
}
