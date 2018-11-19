package com.lu.wang.snakecharmer.data;

import com.lu.wang.snakecharmer.data.Node;

public class TravelPath extends Path {

	public enum Move {
		L("L", "Left"), R("R", "Right");

		private String command;
		private String name;

		Move(String command, String name) {
			this.command = command;
			this.name = name;
		}

		public String getCommand() {
			return command;
		}

		public String getName() {
			return name;
		}

		public static Move fromCommand(String command) {
			if (L.getCommand().equals(command)) {
				return L;
			} else if (R.getCommand().equals(command)) {
				return R;
			}
			return null;
		}
	}

	/**
	 * direction
	 */
	private Move move;

	/**
	 * Constructor
	 * 
	 * @param source
	 * @param destination
	 * @param move
	 */
	public TravelPath(Node source, Node destination, Move move) {
		super(source, destination);
		this.move = move;
	}

	/**
	 * @return the move
	 */
	public Move getMove() {
		return move;
	}

	/**
	 * @param move the move to set
	 */
	public void setMove(Move move) {
		this.move = move;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getSource().toString() + "+" + move.getCommand() + "=>" + getDestination().toString();
	}
}
