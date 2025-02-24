package com.zander404.springandjavaerudio.exceptions;

public class PersonNotFound extends RuntimeException {
    public PersonNotFound(String message) {
        super(message);
    }
}
