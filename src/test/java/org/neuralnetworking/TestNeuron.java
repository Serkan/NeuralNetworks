package org.neuralnetworking;

import org.junit.Before;
import org.neuralnetworking.core.Neuron;

/**
 * Test class for {@link Neuron}.
 * 
 * @author serkan
 * 
 */
public class TestNeuron {

	private Neuron neuron;

	@Before
	public void installNeuron() {
		neuron = new Neuron(5);
	}

}
