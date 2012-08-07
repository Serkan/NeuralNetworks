package org.neuralnetworking.manage;

import java.util.List;

import org.neuralnetworking.core.Layer;
import org.neuralnetworking.core.NeuralNetwork;
import org.neuralnetworking.core.Neuron;
import org.neuralnetworking.util.LayerQueue;

/**
 * Initialize network and runs it.
 * 
 * @author serkan
 * 
 */
public class NetworkManager {

	private NeuralNetwork network;

	// private final double learningRate;

	/**
	 * 
	 * Default constructor.
	 * 
	 * @param network
	 */
	public NetworkManager(NeuralNetwork network, double learningRate) {
		this.network = network;
		// this.learningRate = learningRate;
	}

	public void train(double[] trainingSet, double[] expected) {
		network.initInputs(trainingSet);
		LayerQueue<Layer> layers = network.getLayers();
		int layersCount = layers.size();
		Layer currentLayer = null;
		// this is input layer
		currentLayer = layers.nextValue();
		int currentLayerSize = currentLayer.getSize();
		double[] processSet = new double[currentLayerSize];
		// fill input array with input neuron values
		List<Neuron> currentNeurons = currentLayer.getNeurons();
		for (int i = 0; i < currentLayerSize; i++) {
			double temp = currentNeurons.get(i).getNeuronInput();
			processSet[i] = temp;
		}
		double[] valueSet = null;
		for (int j = 0; j < layersCount; j++) {
			currentLayer = layers.nextValue();
			valueSet = new double[currentLayer.getSize()];
			List<Neuron> neurons = currentLayer.getNeurons();
			int i = 0;
			for (Neuron neuron : neurons) {
				valueSet[i++] = neuron.perform(processSet);
			}
			processSet = valueSet;
			valueSet = null;
		}

	}
}
