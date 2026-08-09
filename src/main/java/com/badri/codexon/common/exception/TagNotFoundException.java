package com.badri.codexon.common.exception;

public class TagNotFoundException extends RuntimeException {
    public TagNotFoundException(Long id) {
        super("There is No Tag with this"+id+"Please check once!");
    }
}
