package com.lu.wang.snakecharmer.travelalgorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lu.wang.snakecharmer.data.Node;
import com.lu.wang.snakecharmer.data.Node.Direction;
import com.lu.wang.snakecharmer.data.TravelPath.Move;

public class TravelNodeMgr {
	private static final Logger log = LoggerFactory.getLogger(TravelNodeMgr.class);

	/**
	 * Move the node with specified moves
	 * 
	 * @param node
	 * @param moves
	 */
	public void calcDestination(Node node, String moves) {
		// Empty moves, do nothing.
		if (moves == null || moves.trim().isEmpty()) {
			return;
		}
		log.debug("calcDestination start " + node.toString() + "+" + moves);
		String[] moveList = moves.split("");
		for (String move : moveList) {
			calcDestination(node, Move.fromCommand(move));
		}
		log.debug("calcDestination finish " + node.toString());
	}

	/**
	 * Move the node with specified move
	 * 
	 * @param node
	 * @param moves
	 */
	public void calcDestination(Node node, Move move) {
		String debug = node.toString() + " moves " + move.getName();
		if (Move.L == move) {
			switch (node.getDirection()) {
			case NORTH:
				node.setX(node.getX() - 1);
				node.setDirection(Direction.WEST);
				break;
			case SOUTH:
				node.setX(node.getX() + 1);
				node.setDirection(Direction.EAST);
				break;
			case WEST:
				node.setY(node.getY() - 1);
				node.setDirection(Direction.SOUTH);
				break;
			case EAST:
				node.setY(node.getY() + 1);
				node.setDirection(Direction.NORTH);
				break;
			default:
				// do nothing
			}
		} else {
			switch (node.getDirection()) {
			case NORTH:
				node.setX(node.getX() + 1);
				node.setDirection(Direction.EAST);
				break;
			case SOUTH:
				node.setX(node.getX() - 1);
				node.setDirection(Direction.WEST);
				break;
			case WEST:
				node.setY(node.getY() + 1);
				node.setDirection(Direction.NORTH);
				break;
			case EAST:
				node.setY(node.getY() - 1);
				node.setDirection(Direction.SOUTH);
				break;
			default:
				// do nothing
			}
		}
		log.debug(debug + " = " + node.toString());
	}
}
