package com.lu.wang.snakecharmer.travelalgorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lu.wang.snakecharmer.data.Node;
import com.lu.wang.snakecharmer.movementinterface.MovementInterface;

public class TravelAlgorithm implements MovementInterface {
	private static final Logger log = LoggerFactory.getLogger(TravelAlgorithm.class);

	public enum Movement {
		UP("LRR", "UP"), DOWN("LLL", "DOWN"), LEFT("L", "LEFT"), RIGHT("R", "RIGHT"), UPLEFT("LR", "UPLEFT"),
		UPRIGHT("RL", "UPRIGHT"), DOWNLEFT("LL", "DOWNLEFT"), DOWNRIGHT("RR", "DOWNRIGHT");

		private String move;
		private String name;

		Movement(String move, String name) {
			this.move = move;
			this.name = name;
		}

		public String getMove() {
			return move;
		}

		public String getName() {
			return name;
		}
	}

	@Override
	public String calcMovement(Node destinationNode) {
		StringBuffer result = new StringBuffer();
		Node currentNode = new Node(0, 0, Node.Direction.NORTH);
		TravelNodeMgr mgr = new TravelNodeMgr();

		while (destinationNode.equals(currentNode, false) == false) {
			Movement m = findMovement(currentNode, destinationNode);
			result.append(m.getMove());
			mgr.calcDestination(currentNode, m.getMove());
		}

		return result.toString();
	}

	/**
	 * 
	 * @param currentNode
	 * @param destinationNode
	 * @return
	 */
	private Movement findMovement(Node currentNode, Node destinationNode) {
		switch (currentNode.getDirection()) {
		case NORTH:
			if (currentNode.getX() == destinationNode.getX() && currentNode.getY() < destinationNode.getY()) {
				return Movement.UP;
			}
			if (currentNode.getX() == destinationNode.getX() && currentNode.getY() > destinationNode.getY()) {
				return Movement.DOWN;
			}
			if (currentNode.getX() > destinationNode.getX() && currentNode.getY() == destinationNode.getY()) {
				return Movement.LEFT;
			}
			if (currentNode.getX() < destinationNode.getX() && currentNode.getY() == destinationNode.getY()) {
				return Movement.RIGHT;
			}
			if (currentNode.getX() > destinationNode.getX() && currentNode.getY() < destinationNode.getY()) {
				return Movement.UPLEFT;
			}
			if (currentNode.getX() < destinationNode.getX() && currentNode.getY() < destinationNode.getY()) {
				return Movement.UPRIGHT;
			}
			if (currentNode.getX() > destinationNode.getX() && currentNode.getY() > destinationNode.getY()) {
				return Movement.DOWNLEFT;
			}
			if (currentNode.getX() < destinationNode.getX() && currentNode.getY() > destinationNode.getY()) {
				return Movement.DOWNRIGHT;
			}
		case SOUTH:
			if (currentNode.getX() == destinationNode.getX() && currentNode.getY() > destinationNode.getY()) {
				return Movement.UP;
			}
			if (currentNode.getX() == destinationNode.getX() && currentNode.getY() < destinationNode.getY()) {
				return Movement.DOWN;
			}
			if (currentNode.getX() < destinationNode.getX() && currentNode.getY() == destinationNode.getY()) {
				return Movement.LEFT;
			}
			if (currentNode.getX() > destinationNode.getX() && currentNode.getY() == destinationNode.getY()) {
				return Movement.RIGHT;
			}
			if (currentNode.getX() < destinationNode.getX() && currentNode.getY() > destinationNode.getY()) {
				return Movement.UPLEFT;
			}
			if (currentNode.getX() > destinationNode.getX() && currentNode.getY() > destinationNode.getY()) {
				return Movement.UPRIGHT;
			}
			if (currentNode.getX() < destinationNode.getX() && currentNode.getY() < destinationNode.getY()) {
				return Movement.DOWNLEFT;
			}
			if (currentNode.getX() > destinationNode.getX() && currentNode.getY() > destinationNode.getY()) {
				return Movement.DOWNRIGHT;
			}
		case WEST:
			if (currentNode.getX() > destinationNode.getX() && currentNode.getY() == destinationNode.getY()) {
				return Movement.UP;
			}
			if (currentNode.getX() < destinationNode.getX() && currentNode.getY() == destinationNode.getY()) {
				return Movement.DOWN;
			}
			if (currentNode.getX() == destinationNode.getX() && currentNode.getY() > destinationNode.getY()) {
				return Movement.LEFT;
			}
			if (currentNode.getX() == destinationNode.getX() && currentNode.getY() < destinationNode.getY()) {
				return Movement.RIGHT;
			}
			if (currentNode.getX() > destinationNode.getX() && currentNode.getY() > destinationNode.getY()) {
				return Movement.UPLEFT;
			}
			if (currentNode.getX() > destinationNode.getX() && currentNode.getY() < destinationNode.getY()) {
				return Movement.UPRIGHT;
			}
			if (currentNode.getX() < destinationNode.getX() && currentNode.getY() > destinationNode.getY()) {
				return Movement.DOWNLEFT;
			}
			if (currentNode.getX() < destinationNode.getX() && currentNode.getY() < destinationNode.getY()) {
				return Movement.DOWNRIGHT;
			}
		case EAST:
			if (currentNode.getX() < destinationNode.getX() && currentNode.getY() == destinationNode.getY()) {
				return Movement.UP;
			}
			if (currentNode.getX() > destinationNode.getX() && currentNode.getY() == destinationNode.getY()) {
				return Movement.DOWN;
			}
			if (currentNode.getX() == destinationNode.getX() && currentNode.getY() < destinationNode.getY()) {
				return Movement.LEFT;
			}
			if (currentNode.getX() == destinationNode.getX() && currentNode.getY() > destinationNode.getY()) {
				return Movement.RIGHT;
			}
			if (currentNode.getX() < destinationNode.getX() && currentNode.getY() < destinationNode.getY()) {
				return Movement.UPLEFT;
			}
			if (currentNode.getX() < destinationNode.getX() && currentNode.getY() > destinationNode.getY()) {
				return Movement.UPRIGHT;
			}
			if (currentNode.getX() > destinationNode.getX() && currentNode.getY() < destinationNode.getY()) {
				return Movement.DOWNLEFT;
			}
			if (currentNode.getX() > destinationNode.getX() && currentNode.getY() > destinationNode.getY()) {
				return Movement.DOWNRIGHT;
			}
		default:
			return null;
		}
	}
}
