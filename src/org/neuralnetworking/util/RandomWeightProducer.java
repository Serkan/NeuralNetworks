package org.neuralnetworking.util;

import java.util.Random;

import org.neuralnetworking.core.Weight;

/**
 * Util class produce random weights.
 * 
 * @author serkan
 * 
 */
public final class RandomWeightProducer {

    public static Weight produce() {
        Weight w = new Weight();
        Random r = new Random();
        w.setWeight(r.nextDouble());
        return w;
    }

}
