package com.badri.codexon.common.exception;

public class ProblemTagNotFoundException extends RuntimeException {
    public ProblemTagNotFoundException(Long id) {
        super("There is no ProblemTag with id:"+id);
    }
}
