package org.neuralnetworking.core;

import java.util.List;

/**
 * Container for neurons.
 * 
 * @author serkan
 * 
 */
public class Layer {

    List<Neuron> neurons;

    /**
     * @return the neurons
     */
    public List<Neuron> getNeurons() {
        return neurons;
    }

    /**
     * @param neurons the neurons to set
     */
    public void setNeurons(List<Neuron> neurons) {
        this.neurons = neurons;
    }

}
