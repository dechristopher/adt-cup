package com.dechristopher.adtcup;

import com.dechristopher.adtcup.Exceptions.*;

import java.util.Stack;

public class Cup<T> {

    //region Instance Variables
    /**
     * Current cup volume in mL
     */
    private int volume;

    /**
     * Max volume of the cup
     */
    private int maxVolume;

    /**
     * Number of elements (liquids) to have been added
     */
    private int elements;

    /**
     * Stack of elements (liquids) in the cup
     */
    private Stack<T> cupStack;
    //endregion Instance Variables

    //region Constants
    /**
     * Default cup size if nothing provided (75 mL)
     */
    private static final int DEFAULT_MAX_VOLUME = 75;
    //endregion Constants

    //region Constructors
    /**
     * Default constructor, assumes 75mL cup
     */
    public Cup(){
        this(DEFAULT_MAX_VOLUME);
    }

    /**
     * Constructor, sets custom volume
     * @param v desired volume of cup
     */
    public Cup(int v){
        this.volume = 0;
        this.maxVolume = v;
        this.elements = 0;
        this.cupStack = new Stack<T>();
    }
    //endregion Constructors

    //region Data Accessors
    /**
     * Pours an element (liquid) into the top of the cup
     * @param newElement generic element (liquid) to add
     * @return whether or not the element (liquid) was poured
     * True when poured successfully and false when cup does not have enough capacity
     * @throws CupInvalidTypeException when an invalid type is poured
     */
    public boolean pour(T newElement) throws CupInvalidTypeException, CupPourException {
        if(newElement != null) {
            if(this.getVolume() <= this.getMaxVolume()){
                int toPourVolume = getVolumeOfElement(newElement);
                if(this.getVolume() + toPourVolume <= this.getMaxVolume()) {
                    if (this.cupStack.add(newElement)) {
                        this.volume += toPourVolume;
                        this.elements++;
                        return true;
                    } else {
                        throw new CupPourException("You shook a little and spilled your liquid all over yourself before it got to the cup.");
                    }
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else{
            throw new NullPointerException("Cups don't accept null liquids...bastard.");
        }
    }

    /**
     * Sips an element (liquid) from the top of the cup and returns it
     * @return element (liquid) that is sipped
     * @throws CupInvalidTypeException when an invalid type is sipped
     * @throws CupElementNegativeVolumeException when an element (liquid) is calculated to have a negative volume)
     */
    public T sip() throws CupInvalidTypeException, CupElementNegativeVolumeException {
        T toSip = this.cupStack.peek();
        int toSipVolume = getVolumeOfElement(toSip);

        if(toSipVolume >= 0){
            this.volume -= toSipVolume;
            this.elements--;
            return toSip;
        }else{
            throw new CupElementNegativeVolumeException();
        }
    }

    /**
     * Dumps all elements (liquids) from the cup
     */
    public void dump(){
        this.cupStack.empty();
        this.volume = 0;
        this.elements = 0;
    }
    //endregion Data Accessors

    //region Calculators
    private int getVolumeOfElement(T element) throws CupInvalidTypeException {
        try {
            //Provided Integer to pour into cup
            if (element instanceof Integer) {

                return Math.abs((Integer)element);

            //Provided Double to pour into cup
            } else if (element instanceof Double) {

                return Math.abs(((Double)element).intValue());

            //Provided String to pour into cup
            } else if (element instanceof String) {

                int volume = 0;
                for(Character c : ((String) element).toCharArray()){
                    volume += c.hashCode();
                }
                return volume;

            //Provided Character to pour into cup
            } else if (element instanceof Character) {

                return ((Character)element).hashCode();

            //Invalid type provided
            } else {
                throw new CupInvalidTypeException("Couldn't get volume of element of type: " + element.getClass().getTypeName());
            }
        }catch(ClassCastException cce){
            throw new CupInvalidTypeException("Something wrong happened. Apparently you broke the application logic. Thanks.");
        }
    }
    //endregion Calculators

    //region Accessors
    /**
     * Returns the current volume of elements (liquids) in the cup
     * @return the current volume of elements (liquids) in the cup
     */
    public int getVolume(){
        return this.volume;
    }

    /**
     * Returns the current max volume of elements (liquids) in the cup
     * @return the current max volume of elements (liquids) in the cup
     */
    public int getMaxVolume(){
        return this.maxVolume;
    }

    /**
     * Returns the current number of elements (liquids) in the cup
     * @return the current number of elements (liquids) in the cup
     */
    public int getNumElements(){
        return this.elements;
    }

    /**
     * Returns the string representation of the cup
     * @return the string representation of the cup
     */
    @Override
    public String toString(){
        return "[CUP] Volume: " + this.getVolume() + "/" + this.getMaxVolume() + " - Elements: " + this.getNumElements();
    }
    //endregion Accessors

    //region State
    /**
     * Returns whether or not the cup is currently empty
     * @return whether or not the cup is currently empty
     * @throws CupStateInvalidException when the stack and volume become out of sync
     */
    public boolean isCupEmpty() throws CupStateInvalidException {
        if(this.cupStack.isEmpty() && this.volume == 0){
            return true;
        }else if(!this.cupStack.isEmpty() && this.volume != 0){
            return false;
        }else if(!this.cupStack.isEmpty() && this.volume == 0){
            throw new CupStateInvalidException("The cup is saying it is empty, yet there is still a volume of liquid present.");
        }else{
            throw new CupStateInvalidException("The cup is saying it is not empty, yet there is not a volume of liquid present.");
        }
    }

    /**
     * Returns whether or not the cup is currently full
     * @return whether or not the cup is currently full
     */
    public boolean isCupFull(){
        return this.volume == this.maxVolume;
    }
    //endregion State
}
