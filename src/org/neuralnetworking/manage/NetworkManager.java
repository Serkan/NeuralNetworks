package org.neuralnetworking.manage;

import java.util.List;
import java.util.Queue;

import org.neuralnetworking.core.Layer;
import org.neuralnetworking.core.NeuralNetwork;
import org.neuralnetworking.core.Neuron;

/**
 * Initialize network and runs it.
 * 
 * @author serkan
 * 
 */
public class NetworkManager {

    private NeuralNetwork network;

    /**
     * 
     * Default constructor.
     * 
     * @param network
     */
    public NetworkManager(NeuralNetwork network) {
        this.network = network;
    }

    public void train(List<Boolean> trainingSet, Boolean expected) {
        // Queue<Layer> layers = network.getLayers();
        // int size = layers.size();
        // List<Boolean> resultSet = trainingSet;
        // for(int i = 0; i < size ; i++){
        // Layer currentLayer = layers.peek();
        // List<Neuron> neurons = currentLayer.getNeurons();
        // for (Neuron neuron : neurons) {
        //
        // }
        //
        // }
    }
}
