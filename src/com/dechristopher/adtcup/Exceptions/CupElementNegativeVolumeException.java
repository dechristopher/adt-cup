package com.dechristopher.adtcup.Exceptions;

/**
 * Created by dechristophera on 11/3/16.
 */
public class CupElementNegativeVolumeException extends Exception {
    /**
     * Creates a new CupElementNegativeVolumeException
     */
    public CupElementNegativeVolumeException(){this("");}

    /**
     * /**
     * Creates a new CupElementNegativeVolumeException with message
     * @param message Message to include
     */
    public CupElementNegativeVolumeException(String message){
        super(message);
    }
}
