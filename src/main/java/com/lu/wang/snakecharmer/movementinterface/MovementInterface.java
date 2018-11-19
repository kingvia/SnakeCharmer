package com.lu.wang.snakecharmer.movementinterface;

import com.lu.wang.snakecharmer.data.Node;

public interface MovementInterface {
	/**
	 * Calculate the movement required from [0,0] to specified node.
	 * 
	 * @param node desitination node
	 * @return the movement required from [0,0] to specified node.
	 */
	public abstract String calcMovement(Node destinationNode);
}
