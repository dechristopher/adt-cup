package com.dechristopher.adtcup.Exceptions;

/**
 * Created by dechristophera on 11/3/16.
 */
public class CupStateInvalidException extends Exception {
    /**
     * Creates a new CupStateInvalidException
     */
    public CupStateInvalidException(){this("");}

    /**
     * /**
     * Creates a new CupStateInvalidException with message
     * @param message Message to include
     */
    public CupStateInvalidException(String message){
        super(message);
    }
}
