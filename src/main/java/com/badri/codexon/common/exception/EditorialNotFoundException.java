package com.badri.codexon.common.exception;

public class EditorialNotFoundException extends BusinessException {
    public EditorialNotFoundException(Long id) {
        super("There is No editorial with id: "+id);
    }
}
