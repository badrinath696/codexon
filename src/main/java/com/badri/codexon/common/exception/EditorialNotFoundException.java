package com.badri.codexon.common.exception;

public class EditorialNotFoundException extends RuntimeException {
    public EditorialNotFoundException(Long id) {
        super("There is No editorial with id: "+id);
    }
}
