package com.badri.codexon.common.exception;

public class TestCaseNotFoundException extends BusinessException {
    public TestCaseNotFoundException(Long id) {
        super("There no TestCase with id: "+id);
    }
}
