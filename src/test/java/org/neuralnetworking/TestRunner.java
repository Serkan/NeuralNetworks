package org.neuralnetworking;

import java.util.Queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.neuralnetworking.core.Layer;
import org.neuralnetworking.core.NeuralNetwork;

/**
 * Test for several network models.
 * 
 * @author serkan
 * 
 */
public class TestRunner {

    private NeuralNetwork network;

    @Before
    public void install_network() {
        network = new NeuralNetwork(2, 1, 0);

    }

    @Test
    public void layers_not_null() {
        Queue<Layer> layerqueue = network.getLayers();
        Assert.assertNotNull(layerqueue);
    }

    @Test
    public void layers_count_assertion() {
        Queue<Layer> layerqueue = network.getLayers();
        Assert.assertTrue((layerqueue.size() == 2));
    }

    @Test
    public void layer_neuron_count() {
        Queue<Layer> layerqueue = network.getLayers();
        // first layer
        Layer layer1 = layerqueue.peek();
        Assert.assertTrue(layer1.getSize() == 1);
        // second layer
        Layer layer2 = layerqueue.peek();
        Assert.assertTrue(layer2.getSize() == 1);
    }

}
