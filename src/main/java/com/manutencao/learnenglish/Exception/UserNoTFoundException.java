package com.manutencao.learnenglish.Exception;

/**
 * @author Marcelo Estevam
 */
public class UserNoTFoundException extends RuntimeException {

    /**
     *
     * @param message
     *       The detail message (which is saved for later retrieval
     *       by the {@link #getMessage()} method)
     */
    public UserNoTFoundException(String message) {
        super(message);
    }


}
