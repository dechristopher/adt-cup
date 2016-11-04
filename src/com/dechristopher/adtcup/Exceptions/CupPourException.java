package com.dechristopher.adtcup.Exceptions;

/**
 * Created by dechristophera on 11/3/16.
 */
public class CupPourException extends Exception {
    /**
     * Creates a new CupPourException
     */
    public CupPourException(){this("");}

    /**
     * /**
     * Creates a new CupPourException with message
     * @param message Message to include
     */
    public CupPourException(String message){
        super(message);
    }
}
