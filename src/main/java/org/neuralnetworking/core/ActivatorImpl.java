package org.neuralnetworking.core;

public class ActivatorImpl implements ActivatorFunction {

	private static double THERSHOLD = 0.5;

	@Override
	public boolean activate(double value) {
		return value > THERSHOLD;
	}

}
