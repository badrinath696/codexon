package com.badri.codexon.common.exception;

public class DuplicateProblemException extends BusinessException{
    public DuplicateProblemException(String title){
        super("This problem already exist with this title : "+title);
    }
}
