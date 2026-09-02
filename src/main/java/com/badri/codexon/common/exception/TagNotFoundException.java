package com.badri.codexon.common.exception;

public class TagNotFoundException extends BusinessException {
    public TagNotFoundException(Long id) {
        super("There is No Tag with id "+id+". Please check once!");
    }
}
