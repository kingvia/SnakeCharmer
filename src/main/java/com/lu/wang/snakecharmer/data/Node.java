package com.lu.wang.snakecharmer.data;

public class Node {

	public enum Direction {
		NORTH, SOUTH, EAST, WEST
	}

	/**
	 * x
	 */
	private int x;

	/**
	 * y
	 */
	private int y;

	/**
	 * direction
	 */
	private Direction direction;

	/**
	 * Constructor
	 * 
	 * @param x
	 * @param y
	 */
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Constructor
	 * 
	 * @param x
	 * @param y
	 */
	public Node(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the direction
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	/**
	 * Indicates whether some other object is "equal to" this one.
	 * 
	 * @param obj the reference object with which to compare.
	 * @return true if this object is the same as the obj argument; false otherwise.
	 */
	public boolean equals(Node obj) {
		return equals(obj, true);
	}

	/**
	 * Indicates whether some other object is "equal to" this one.
	 * 
	 * @param obj            the reference object with which to compare.
	 * @param checkDirection flag if check the directon field or not.
	 * @return true if this object is the same as the obj argument; false otherwise.
	 */
	public boolean equals(Node obj, boolean checkDirection) {
		boolean result = (getX() == obj.getX()) && (getY() == obj.getY());
		if (checkDirection) {
			result = result && (getDirection() == obj.getDirection());
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + getX() + "," + getY() + "," + getDirection() + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
}
