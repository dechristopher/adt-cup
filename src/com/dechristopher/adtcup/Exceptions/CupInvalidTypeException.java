package com.dechristopher.adtcup.Exceptions;

/**
 * Created by dechristophera on 11/3/16.
 */
public class CupInvalidTypeException extends Exception {
    /**
     * Creates a new CupInvalidTypeException
     */
    public CupInvalidTypeException(){this("");}

    /**
     * /**
     * Creates a new CupInvalidTypeException with message
     * @param message Message to include
     */
    public CupInvalidTypeException(String message){
        super(message);
    }
}
