package org.neuralnetworking.main;

import org.neuralnetworking.core.Layer;
import org.neuralnetworking.core.NeuralNetwork;
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
		Layer layer1 = network.getLayers().nextValue();
		Layer layer2 = network.getLayers().nextValue();
		logger.debug("layer 1 : " + layer1.getLayerId());
		logger.debug("layer 2 : " + layer2.getLayerId());
		logger.debug("layer 1 size : " + layer1.getSize());
		logger.debug("layer 2 size : " + layer2.getSize());
	}

}
