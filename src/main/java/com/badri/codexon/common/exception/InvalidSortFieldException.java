package com.badri.codexon.common.exception;

public class InvalidSortFieldException extends RuntimeException{
    public InvalidSortFieldException(String sort){
        super(sort+" is not valid field for sorting!");
    }
}
