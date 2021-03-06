package org.neuralnetworking.core;

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

	private double[] weigths;

	private ActivatorFunction activator;

	private int output;

	private double[] inputVector;

	private boolean inputNeuron = false;

	private double neuronInput;

	/**
	 * 
	 * Default constructor.
	 * 
	 * @param inputsize
	 *            Previous layer neuron count
	 */
	public Neuron(int inputsize) {
		logger.info("Neuron id : " + getNeuronId());
		logger.info("Neuron input size : " + inputsize);
		activator = new ActivatorImpl();
		output = 0;
		// producing and assigning random weights
		weigths = new double[inputsize];
		for (int i = 0; i < inputsize; i++) {
			weigths[i] = (RandomWeightProducer.produce());
		}
	}

	/**
	 * Multipy input vector with weight vector.
	 * 
	 * @param input
	 *            Inputs
	 * @return active or not
	 */
	public int perform(double[] input) {
		if (getWeightSize() == input.length) {
			double sum = 0;
			for (int i = 0; i < input.length; i++) {
				sum += input[i] * weigths[i];
			}
			if (activator.activate(sum)) {
				return 1;
			} else {
				return 0;
			}
		} else {
			throw new RuntimeException("Weight and input size are not equal");
		}
	}

	public void changeWeights(double learningRate, int expected) {
		for (int i = 0; i < weigths.length; i++) {
			double oldWeight = weigths[i];
			double newWeight = (learningRate * (output - expected) * oldWeight)
					* inputVector[i];
			weigths[i] = newWeight;
		}
	}

	/**
	 * @return the inputNeuron
	 */
	public boolean isInputNeuron() {
		return inputNeuron;
	}

	/**
	 * @return the neuronInput
	 */
	public double getNeuronInput() {
		return neuronInput;
	}

	/**
	 * @param neuronInput
	 *            the neuronInput to set
	 */
	public void setNeuronInput(double neuronInput) {
		this.neuronInput = neuronInput;
	}

	/**
	 * Getter for weight vector size.
	 * 
	 * @return Size of vector
	 */
	public int getWeightSize() {
		return weigths.length;
	}

}
