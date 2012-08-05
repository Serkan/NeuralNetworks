package org.neuralnetworking.core;

import java.util.ArrayList;
import java.util.List;

import org.neuralnetworking.util.RandomWeightProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Network nodes, calculate value and runs activator function.
 * 
 * @author serkan
 * 
 */
public class Neuron extends AbstractNeuron {

    Logger logger = LoggerFactory.getLogger(Neuron.class);

    private List<Weight> weigths;

    private ActivatorFunction activator;

    private int output;

    private List<Boolean> inputVector;

    private boolean inputNeuron = false;

    public Neuron() {
        logger.info("Input neuron");
        activator = new ActivatorImpl();
        inputNeuron = true;
    }

    /**
     * 
     * Default constructor.
     * 
     * @param inputsize Previous layer neuron count
     */
    public Neuron(int inputsize) {
        logger.info("Neuron id : " + getNeuronId());
        logger.info("Neuron input size : " + inputsize);
        activator = new ActivatorImpl();
        weigths = new ArrayList<Weight>();
        output = 0;
        for (int i = 0; i < inputsize; i++) {
            weigths.add(RandomWeightProducer.produce());
        }

    }

    /**
     * Multipy input vector with weight vector.
     * 
     * @param input Inputs
     * @return active or not
     */
    public boolean perform(List<Boolean> input) {
        if (weigths.size() == input.size()) {
            double result = 0;
            for (int i = 0; i < weigths.size(); i++) {
                int temp = 0;
                if (input.get(i)) {
                    temp = 1;
                }
                result += temp * weigths.get(i).getWeight();
            }
            if (activator.activate(result)) {
                output = 1;
                return true;
            } else {
                return false;
            }
        } else {
            throw new RuntimeException("Weight and input size are not equal");
        }
    }

    public void changeWeights(double learningRate, int expected) {
        for (int i = 0; i < weigths.size(); i++) {
            int input = 0;
            if (inputVector.get(i)) {
                input = 1;
            }
            double oldWeight = weigths.get(i).getWeight();
            double newWeight = (learningRate * (output - expected) * oldWeight)
                    * input;
            weigths.get(i).setWeight(newWeight);
        }
    }

    /**
     * @return the weigths
     */
    public List<Weight> getWeigths() {
        return weigths;
    }

    /**
     * @param weigths the weigths to set
     */
    public void setWeigths(List<Weight> weigths) {
        this.weigths = weigths;
    }

    /**
     * @return the inputNeuron
     */
    public boolean isInputNeuron() {
        return inputNeuron;
    }

}
