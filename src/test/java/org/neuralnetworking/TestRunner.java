package org.neuralnetworking;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.neuralnetworking.core.Layer;
import org.neuralnetworking.core.NeuralNetwork;
import org.neuralnetworking.core.Neuron;
import org.neuralnetworking.util.LayerQueue;

/**
 * Test for several network models.
 * 
 * @author serkan
 * 
 */
public class TestRunner extends Assert {

	private static NeuralNetwork network;

	@BeforeClass
	public static void install_network() {
		network = new NeuralNetwork(2, 1, 0);
	}

	@Test
	public void testLayersNotNull() {
		LayerQueue<Layer> layers = network.getLayers();
		assertNotNull(layers);
	}

	@Test
	public void testInputLayerSize() {
		LayerQueue<Layer> layers = network.getLayers();
		assertTrue(2 == layers.nextValue().getSize());
	}

	@Test
	public void testOutputLayerSize() {
		LayerQueue<Layer> layers = network.getLayers();
		Layer lastLayer = null;
		lastLayer = layers.getLast();
		assertTrue(1 == lastLayer.getSize());
	}

	@Test
	public void testHiddenLayerCount() {
		LayerQueue<Layer> layers = network.getLayers();
		int hiddenLayerCount = layers.size() - 2;
		assertTrue(hiddenLayerCount == 0);
	}

	@Test
	public void testHiddenLayerNeuronWeightSize() {
		LayerQueue<Layer> layers = network.getLayers();
		Layer preLayer = null;
		Layer nextLayer = null;
		preLayer = layers.nextValue();
		nextLayer = layers.nextValue();
		int preLayerSize = preLayer.getSize();
		List<Neuron> neurons = nextLayer.getNeurons();
		for (Neuron neuron : neurons) {
			assertTrue(neuron.getWeightSize() == preLayerSize);
		}
	}

}
