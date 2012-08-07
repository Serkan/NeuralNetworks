package org.neuralnetworking.core;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Container for neurons.
 * 
 * @author serkan
 * 
 */
public class Layer extends AbstractLayer implements Comparable<Layer> {

	Logger logger = LoggerFactory.getLogger(Layer.class);

	List<Neuron> neurons;

	/**
	 * 
	 * Default constructor.
	 * 
	 * @param layerSize
	 *            Neuron count which layer contains
	 * @param preLayerSize
	 */
	public Layer(int layerSize, int preLayerSize) {
		logger.info("Layer id :" + getLayerId());
		neurons = new ArrayList<Neuron>();
		Neuron tempNeuron = null;
		for (int i = 0; i < layerSize; i++) {
			tempNeuron = new Neuron(preLayerSize);
			neurons.add(tempNeuron);
		}
	}

	/**
	 * @return the neurons
	 */
	public List<Neuron> getNeurons() {
		return neurons;
	}

	/**
	 * Size of containing neurons.
	 * 
	 * @return Neuron size
	 */
	public int getSize() {
		return neurons.size();
	}

	@Override
	public int compareTo(Layer o) {
		int otherId = o.getLayerId();
		int layerId = getLayerId();
		if (otherId < layerId) {
			return -1;
		} else if (otherId > layerId) {
			return 1;
		} else {
			return 0;
		}
	}

}
