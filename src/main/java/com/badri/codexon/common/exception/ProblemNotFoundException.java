package com.badri.codexon.common.exception;

public class ProblemNotFoundException extends BusinessException{
    public ProblemNotFoundException(Long problemId){
        super(
              "Invalid id! There is no problem with id: "+problemId
        );
    }
}
