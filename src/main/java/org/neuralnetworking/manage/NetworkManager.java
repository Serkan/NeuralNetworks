package org.neuralnetworking.manage;

import java.util.ArrayList;
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

    private final double learningRate;

    /**
     * 
     * Default constructor.
     * 
     * @param network
     */
    public NetworkManager(NeuralNetwork network, double learningRate) {
        this.network = network;
        this.learningRate = learningRate;
    }

    public void train(List<Boolean> trainingSet, Boolean expected) {
        Queue<Layer> layers = network.getLayers();
        int size = layers.size();
        List<Boolean> resultSet = trainingSet;
        // travarse layers by peeking from layer queue
        for (int i = 0; i < size; i++) {
            List<Boolean> tempResult = new ArrayList<Boolean>();
            Layer currentLayer = layers.peek();
            List<Neuron> neurons = currentLayer.getNeurons();
            for (Neuron neuron : neurons) {
                boolean singleResult = neuron.perform(resultSet);
                // if we did not get expected result,change weights of current
                // neuron
                if (!expected.equals(singleResult)) {
                    int ex = 0;
                    if (expected) {
                        ex = 1;
                    }
                    neuron.changeWeights(learningRate, ex);
                }
                tempResult.add(singleResult);
            }
            resultSet = tempResult;
        }
    }
}
