package org.neuralnetworking.core;

/**
 * Abstraction for all layer implementation and identification manager.
 * 
 * @author serkan
 * 
 */
public class AbstractLayer {

    private static int ID_COUNTER = 0;

    private int layerId;

    /**
     * 
     * Default constructor.
     */
    public AbstractLayer() {
        this.layerId = ID_COUNTER++;
    }

    /**
     * @return the layerId
     */
    public int getLayerId() {
        return layerId;
    }

}
