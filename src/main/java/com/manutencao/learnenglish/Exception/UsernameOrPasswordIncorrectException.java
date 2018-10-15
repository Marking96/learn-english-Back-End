package com.manutencao.learnenglish.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Marcelo Estevam
 */

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UsernameOrPasswordIncorrectException extends RuntimeException {

    /**
     *
     * @param message
     *       The detail message (which is saved for later retrieval
     *       by the {@link #getMessage()} method)
     */
    public UsernameOrPasswordIncorrectException(String message) {
        super(message);
    }
}
