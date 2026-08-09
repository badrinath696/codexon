package com.badri.codexon.common.exception;

public class ExampleNotFoundException extends RuntimeException {
    public ExampleNotFoundException(Long exampleId) {
        super("There is no Example with id:"+exampleId);
    }
}
