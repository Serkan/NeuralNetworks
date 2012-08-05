package org.neuralnetworking.core;

/**
 * Abstraction for all neuron implementations and identification assignment
 * manager.
 * 
 * @author serkan
 * 
 */
public abstract class AbstractNeuron {

    private static int ID_COUNTER = 0;

    private int neuronId;

    /**
     * 
     * Default constructor.
     */
    public AbstractNeuron() {
        this.neuronId = ID_COUNTER++;
    }

    /**
     * @return the neuronId
     */
    public int getNeuronId() {
        return neuronId;
    }

}
