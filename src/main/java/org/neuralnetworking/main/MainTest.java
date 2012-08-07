package org.neuralnetworking.main;

import java.util.List;

import org.neuralnetworking.core.Layer;
import org.neuralnetworking.core.NeuralNetwork;
import org.neuralnetworking.core.Neuron;
import org.neuralnetworking.util.LayerQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainTest {

	private static Logger logger = LoggerFactory.getLogger(MainTest.class);

	/**
	 * It for debuging.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		NeuralNetwork network = new NeuralNetwork(2, 1, 0);
		LayerQueue<Layer> layers = network.getLayers();
		Layer preLayer = null;
		Layer nextLayer = null;
		preLayer = layers.nextValue();
		nextLayer = layers.nextValue();
		int preLayerSize = preLayer.getSize();
		List<Neuron> neurons = nextLayer.getNeurons();
		for (Neuron neuron : neurons) {
			System.out.println(neuron.getWeightSize());
		}
	}

}
