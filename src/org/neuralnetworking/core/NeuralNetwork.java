package org.neuralnetworking.core;

import java.util.List;

/**
 * Holds entire network through layers.
 * 
 * @author serkan
 * 
 */
public class NeuralNetwork {

    private List<Layer> layers;

    /**
     * @return the layers
     */
    public List<Layer> getLayers() {
        return layers;
    }

    /**
     * @param layers the layers to set
     */
    public void setLayers(List<Layer> layers) {
        this.layers = layers;
    }

}
