package com.lld.questions.vendingmachine.exceptions;

public class ChangeNotAvailableException extends RuntimeException {

    public ChangeNotAvailableException(String message) {
        super(message);
    }
}
