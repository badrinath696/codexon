package com.badri.codexon.common.exception;

public class TestCaseNotFoundException extends RuntimeException {
    public TestCaseNotFoundException(Long id) {
        super("There no TestCase with id: "+id);
    }
}
