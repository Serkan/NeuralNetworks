package org.neuralnetworking.util;

import java.util.Random;

/**
 * Util class produce random weights.
 * 
 * @author serkan
 * 
 */
public final class RandomWeightProducer {

    public static double produce() {
        Random r = new Random();
        return r.nextDouble();
    }

}
