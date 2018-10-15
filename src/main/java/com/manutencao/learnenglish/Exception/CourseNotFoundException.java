package com.manutencao.learnenglish.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CourseNotFoundException extends  RuntimeException {

    /**
     *
     * @param message
     *      The detail message (which is saved for later retrieval
     *      *        by the {@link #getMessage()} method)
     */
    public CourseNotFoundException(String message) {
        super(message);
    }
}
