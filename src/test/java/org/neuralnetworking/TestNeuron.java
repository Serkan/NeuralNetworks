package org.neuralnetworking;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.neuralnetworking.core.Neuron;
import org.neuralnetworking.core.Weight;

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
