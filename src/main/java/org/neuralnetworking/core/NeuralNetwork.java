package org.neuralnetworking.core;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Holds entire network through layers.
 * 
 * @author serkan
 * 
 */
public class NeuralNetwork {

    private Queue<Layer> layers;

    public NeuralNetwork(int layerCount, int neuronCount) {
        layers = new PriorityQueue<Layer>();
        for (int i = 0; i < layerCount; i++) {
            Layer layer = new Layer();
            for (int j = 0; j < neuronCount; j++) {
                layer.addNeuron(new Neuron(neuronCount));
            }
            layers.add(layer);
        }
    }

    /**
     * @return the layers
     */
    public Queue<Layer> getLayers() {
        return layers;
    }

    /**
     * @param layers the layers to set
     */
    public void setLayers(Queue<Layer> layers) {
        this.layers = layers;
    }

}
