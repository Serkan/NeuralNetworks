package org.neuralnetworking.util;

import java.util.ArrayList;

public class LayerQueue<T> extends ArrayList<T> {

	private static final long serialVersionUID = 5482678213646417188L;

	private int cursor;

	/**
	 * Default constructor.
	 */
	public LayerQueue() {
		cursor = 0;
	}

	/**
	 * Gets the element which cursor is on.
	 * 
	 * @return T element
	 */
	public T nextValue() {
		if (cursor == size()) {
			cursor = 0;
		}
		return get(cursor++);
	}

	/**
	 * Checks the cursor wheter is top of queue.
	 * 
	 * @return True if its top element on queue
	 */
	public boolean isTop() {
		return cursor == 0;
	}

	/**
	 * Checks the cursor wheter is bottom of queue.
	 * 
	 * @return
	 */
	public boolean isBottom() {
		return cursor == size();
	}

	/**
	 * Gtter for top element.
	 * 
	 * @return Top element in the queue
	 */
	public T getFirst() {
		return get(0);
	}

	/**
	 * Getter for bottom element.
	 * 
	 * @return Bottom element in the queue
	 */
	public T getLast() {
		return get(size() - 1);
	}

}
